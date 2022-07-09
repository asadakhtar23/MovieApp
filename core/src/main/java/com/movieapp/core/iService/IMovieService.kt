package com.movieapp.core.iService

import com.movieapp.core.models.category.MovieCategoryResponse
import com.movieapp.core.models.NetworkResult
import com.movieapp.core.models.details.MovieDetailResponse
import kotlinx.coroutines.flow.Flow

interface IMovieService {
    fun getMovieDetails(movieId: Int): Flow<NetworkResult<MovieDetailResponse>>
    fun getMoviesByCategory(category: String): Flow<NetworkResult<MovieCategoryResponse>>
}