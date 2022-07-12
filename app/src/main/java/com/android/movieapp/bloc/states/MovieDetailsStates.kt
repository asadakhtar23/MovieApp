package com.android.movieapp.bloc.states

import com.movieapp.core.models.details.MovieDetailResponse

sealed class MovieDetailsStates {
    object Initial : MovieDetailsStates()
    object Loading : MovieDetailsStates()
    object Error : MovieDetailsStates()
    data class MovieDetailsFetched(val data: MovieDetailResponse) : MovieDetailsStates()
}
