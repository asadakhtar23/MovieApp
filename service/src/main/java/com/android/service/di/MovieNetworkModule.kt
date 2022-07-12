package com.android.service.di

import com.movieapp.core.iNetwork.IMovieNetwork
import com.movieapp.network.MovieNetwork
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ActivityRetainedComponent::class)
abstract class MovieNetworkModule {

    @Binds
    abstract fun bindMovieNetwork(movieNetwork: MovieNetwork): IMovieNetwork
}