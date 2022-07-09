package com.android.movieapp

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MovieApp: Application() {
    companion object {
        lateinit var instance: MovieApp
            private set
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}