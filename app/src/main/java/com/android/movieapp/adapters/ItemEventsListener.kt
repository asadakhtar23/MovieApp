package com.android.movieapp.adapters

import com.android.movieapp.bloc.events.CategoryEvent
import com.android.movieapp.bloc.events.MovieDetailsEvent
import com.android.movieapp.bloc.states.CategoryState
import com.movieapp.core.models.app.Category

interface ItemEventsListener {
    fun onCategoryEventListener(position: Int, category: Category, categoryEvent: CategoryEvent, state: (CategoryState) -> Unit)
    fun onMovieDetailsEventListener(position: Int, movieId: Int, movieDetailsEvent: MovieDetailsEvent)
}