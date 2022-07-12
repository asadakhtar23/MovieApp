package com.movieapp.network

import com.movieapp.core.models.category.MovieCategoryResponse
import com.movieapp.core.models.details.MovieDetailResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface MovieApi {
    @GET("movie/{categoryId}")
    suspend fun getMovieByCategory(@Path("categoryId") categoryId: String): Response<MovieCategoryResponse>

    @GET("movie/{movieId}}")
    suspend fun getMovieDetails(@Path("movieId") movieId: Int): Response<MovieDetailResponse>
}