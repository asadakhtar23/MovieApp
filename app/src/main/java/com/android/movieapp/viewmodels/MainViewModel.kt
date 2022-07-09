package com.android.movieapp.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.service.MovieService
import com.movieapp.core.models.category.MovieCategoryResponse
import com.movieapp.core.models.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val movieService: MovieService): ViewModel()  {

    private val _response: MutableLiveData<NetworkResult<MovieCategoryResponse>> = MutableLiveData()

    val response: LiveData<NetworkResult<MovieCategoryResponse>> = _response

    fun fetchMoviesByCategory(category: String) = viewModelScope.launch {
        movieService.getMoviesByCategory(category).collect { values ->
            _response.value = values
        }
    }

}