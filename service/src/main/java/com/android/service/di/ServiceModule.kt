package com.android.service.di

import com.android.service.MovieService
import com.movieapp.core.Constants.Companion.BASE_URL
import com.movieapp.network.MovieApi
import com.movieapp.network.MovieNetwork
import com.movieapp.network.interceptor.MovieApiInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

//@Module
//@InstallIn(SingletonComponent::class)
//class ServiceModule {
//
//    @Singleton
//    @Provides
//    fun provideMovieService(movieNetwork: MovieNetwork): MovieService {
//        return MovieService(movieNetwork)
//    }
//
//}