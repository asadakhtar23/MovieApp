package com.android.movieapp.bloc.events

sealed class CategoryEvent {
    object Expand : CategoryEvent()
    object Collapse : CategoryEvent()
}