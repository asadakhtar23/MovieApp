package com.android.movieapp

import android.app.Application
import com.movieapp.core.Constants.Companion.LIB_NAME_MY_APP
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MovieApp: Application() {
    companion object {
        lateinit var instance: MovieApp
            private set

        init {
            System.loadLibrary(LIB_NAME_MY_APP)
        }
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}