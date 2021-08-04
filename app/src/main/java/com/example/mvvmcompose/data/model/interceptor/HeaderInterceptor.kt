package com.example.mvvmcompose.data.model.interceptor

import okhttp3.Interceptor
import okhttp3.Response

class HeaderInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val original = chain.request()
        val requestBuilder = original.newBuilder()
            .addHeader("x-rapidapi-key","c505d10708msh5c79fe863494586p196a22jsn77e89535f622")
        val request = requestBuilder.build()
        return chain.proceed(request)

    }
}