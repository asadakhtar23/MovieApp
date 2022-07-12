package com.android.service

import com.movieapp.core.iService.IMovieService
import com.movieapp.core.models.BaseApiResponse
import com.movieapp.core.models.category.MovieCategoryResponse
import com.movieapp.core.models.NetworkResult
import com.movieapp.core.models.details.MovieDetailResponse
import com.movieapp.network.MovieNetwork
import dagger.hilt.android.scopes.ActivityRetainedScoped
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

@ActivityRetainedScoped
class MovieService @Inject constructor(private val movieNetwork: MovieNetwork): IMovieService, BaseApiResponse() {

    override fun getMovieDetails(movieId: Int): Flow<NetworkResult<MovieDetailResponse>> {
        return flow {
            emit(safeApiCall { movieNetwork.getMovieDetails(movieId) })
        }.flowOn(Dispatchers.IO)
    }

    override fun getMoviesByCategory(category: String): Flow<NetworkResult<MovieCategoryResponse>> {
        return flow {
            emit(safeApiCall { movieNetwork.getMoviesByCategory(category) })
        }.flowOn(Dispatchers.IO)
    }
}