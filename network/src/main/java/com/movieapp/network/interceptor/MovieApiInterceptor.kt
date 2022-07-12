package com.movieapp.network.interceptor

import com.movieapp.network.MyApp
import okhttp3.Interceptor
import okhttp3.Response

class MovieApiInterceptor : Interceptor {

    private val tmdbParam = "api_key"

    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val tmdb = MyApp().getMyApp()
        val requestBuilder = originalRequest.newBuilder()

        if (originalRequest.method == "GET") {
            val url = originalRequest.url.toString()
            val newUrl = if(url.contains("?"))
                            "$url&$tmdbParam=$tmdb"
                         else
                            "$url?$tmdbParam=$tmdb"
            requestBuilder.url(newUrl)
        }

        val request = requestBuilder.build()
        return chain.proceed(request)
    }
}