package com.movieapp.core.iNetwork

import com.movieapp.core.models.category.MovieCategoryResponse
import com.movieapp.core.models.details.MovieDetailResponse
import retrofit2.Response

interface IMovieNetwork {
    suspend fun getMovieDetails(movieId: Int): Response<MovieDetailResponse>
    suspend fun getMoviesByCategory(category: String, page: Int): Response<MovieCategoryResponse>
}