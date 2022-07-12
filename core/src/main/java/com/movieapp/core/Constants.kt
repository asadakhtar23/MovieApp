package com.movieapp.core

class Constants {
    companion object {
        const val BASE_URL = "https://api.themoviedb.org/3/"
        const val IMAGE_BASE_URL = "https://image.tmdb.org/t/p/w500"
    }
}

object Categories {
    const val LATEST_MOVIE = "now_playing"
    const val POPULAR_MOVIE = "popular"
    const val TOP_RATED_MOVIE = "top_rated"
    const val UPCOMING_MOVIE = "upcoming"

    const val FETCH_LATEST_MOVIE_TIME_INTERVAL: Long = 30000
}