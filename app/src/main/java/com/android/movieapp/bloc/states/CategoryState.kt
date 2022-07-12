package com.android.movieapp.bloc.states

import com.movieapp.core.models.category.Results

sealed class CategoryState {
    object Initial : CategoryState()
    object Loading : CategoryState()
    data class CategoryDataFetched(val data: List<Results>) : CategoryState()
}
