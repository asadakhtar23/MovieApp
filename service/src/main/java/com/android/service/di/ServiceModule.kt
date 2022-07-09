package com.android.service.di

import com.movieapp.core.iNetwork.IMovieNetwork
import com.movieapp.network.MovieNetwork
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class ServiceModule {
    @Binds
    abstract fun bindMovieNetwork(movieNetwork: MovieNetwork): IMovieNetwork
}