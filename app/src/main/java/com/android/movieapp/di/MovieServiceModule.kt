package com.android.movieapp.di

import com.android.service.MovieService
import com.movieapp.core.iService.IMovieService
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class MovieServiceModule {
    @Binds
    abstract fun bindMovieService(movieService: MovieService): IMovieService
}