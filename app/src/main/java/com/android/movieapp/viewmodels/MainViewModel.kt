package com.android.movieapp.viewmodels

import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.lifecycle.*
import com.android.movieapp.adapters.ItemEventsListener
import com.android.movieapp.bloc.events.CategoryEvent
import com.android.movieapp.bloc.events.MovieDetailsEvent
import com.android.movieapp.bloc.states.CategoryState
import com.android.movieapp.bloc.states.MovieDetailsStates
import com.android.service.MovieService
import com.movieapp.core.Categories
import com.movieapp.core.Categories.FETCH_LATEST_MOVIE_TIME_INTERVAL
import com.movieapp.core.models.NetworkResult
import com.movieapp.core.models.app.Category
import com.movieapp.core.models.category.Results
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(private val movieService: MovieService): BaseViewModel(), ItemEventsListener  {

    private val _responseMoviesByCategory: MutableLiveData<List<Category>> = MutableLiveData()

    val responseMoviesByCategory: LiveData<List<Category>> = _responseMoviesByCategory

    private val _responseMovieDetails: MutableLiveData<MovieDetailsStates> = MutableLiveData()

    val responseMovieDetails: LiveData<MovieDetailsStates> = _responseMovieDetails

    private var movieList = mutableListOf<Results>()

    private var pollState = false

    private fun fetchMoviesByCategory(category: Category) = viewModelScope.launch {
        movieService.getMoviesByCategory(category.slug).collect { values ->
            when (values) {
                is NetworkResult.Success -> {
                    movieList = values.data?.results!!
                    Log.e("response", values.data.toString())
                }
                is NetworkResult.Error -> {
                    showErrorMessage.value = values.message!!
                    Log.e("Error", values.message!!)
                }
                is NetworkResult.Loading -> {

                }
            }

        }
    }

    private fun fetchMovieDetails(movieId: Int) = viewModelScope.launch {
        movieService.getMovieDetails(movieId).collect { values ->

            when (values) {
                is NetworkResult.Success -> {
                    _responseMovieDetails.value = MovieDetailsStates.MovieDetailsFetched(values.data!!)
                    Log.e("response", values.data.toString())
                }
                is NetworkResult.Error -> {
                    _responseMovieDetails.value = MovieDetailsStates.Error(values.message!!)
                }
                is NetworkResult.Loading -> {
                    _responseMovieDetails.value = MovieDetailsStates.Loading
                }
            }
        }
    }

    override fun onCategoryEventListener(
        position: Int,
        category: Category,
        categoryEvent: CategoryEvent,
        state: (CategoryState) -> Unit
    ) {
        when (categoryEvent) {
            is CategoryEvent.Expand -> {
                state(CategoryState.Loading)
                viewModelScope.launch {
                    fetchMoviesByCategory(category).join()
                    state(CategoryState.CategoryDataFetched(movieList))

                    if(category.slug == Categories.LATEST_MOVIE) {
                        pollState = true
                        startLatestMoviePoll(category, state)
                    }

                }
            }
            is CategoryEvent.Collapse -> {
                if(category.slug == Categories.LATEST_MOVIE) {
                    pollState = false
                }
            }
        }
    }

    private fun startLatestMoviePoll(
        category: Category,
        state: (CategoryState) -> Unit
    ) {

        Handler(Looper.myLooper()!!).postDelayed({

            if(pollState) {
                viewModelScope.launch {
                    fetchMoviesByCategory(category).join()
                    state(CategoryState.CategoryDataFetched(movieList))
                    startLatestMoviePoll(category, state)
                }
            }

        }, FETCH_LATEST_MOVIE_TIME_INTERVAL)

    }

    override fun onMovieDetailsEventListener(
        position: Int,
        movieId: Int,
        movieDetailsEvent: MovieDetailsEvent
    ) {
        when (movieDetailsEvent) {
            is MovieDetailsEvent.MovieDetails -> {
                fetchMovieDetails(movieId)
            }
        }
    }

    fun initCategoryList() {
        val categoryList = mutableListOf<Category>()

        categoryList.add(
            Category("Latest Movies", Categories.LATEST_MOVIE, mutableListOf(),
                loadInitially = true,
                isExpandable = true
            )
        )
        categoryList.add(
            Category("Popular Movies", Categories.POPULAR_MOVIE, mutableListOf(),
                loadInitially = true,
                isExpandable = true
            )
        )
        categoryList.add(
            Category("Top Rated Movies", Categories.TOP_RATED_MOVIE, mutableListOf(),
                loadInitially = false,
                isExpandable = false
            )
        )
        categoryList.add(
            Category("Upcoming Movies", Categories.UPCOMING_MOVIE, mutableListOf(),
                loadInitially = false,
                isExpandable = false
            )
        )

        _responseMoviesByCategory.value = categoryList
    }


}