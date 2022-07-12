package com.movieapp.network

import com.movieapp.core.iNetwork.IMovieNetwork
import com.movieapp.core.models.category.MovieCategoryResponse
import com.movieapp.core.models.details.MovieDetailResponse
import retrofit2.Response
import javax.inject.Inject

class MovieNetwork @Inject constructor(private val movieApi: MovieApi): IMovieNetwork {
    override suspend fun getMovieDetails(movieId: Int):Response<MovieDetailResponse> {
        return movieApi.getMovieDetails(movieId)
    }

    override suspend fun getMoviesByCategory(category: String):Response<MovieCategoryResponse> {
        return movieApi.getMovieByCategory(category)
    }
}