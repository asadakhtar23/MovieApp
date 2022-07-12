package com.movieapp.network.interceptor

import okhttp3.Interceptor
import okhttp3.Response

class MovieApiInterceptor : Interceptor {

    val tmdbParam = "api_key"

    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val tmdb = "003fcbd729a751c39f31ecd676801be7"
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