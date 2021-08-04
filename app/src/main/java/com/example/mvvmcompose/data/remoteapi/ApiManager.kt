package com.example.mvvmcompose.data.remoteapi

import com.example.mvvmcompose.data.model.interceptor.HeaderInterceptor
import com.example.mvvmcompose.data.remoteapi.ApiConstants.Api.APP_URL
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.HttpUrl
import okhttp3.HttpUrl.Companion.toHttpUrl
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

class ApiManager {

    companion object {
        private var apiManagerInstance: ApiManager? = null

        fun getApiManagerInstance(): ApiManager {
            if (apiManagerInstance == null) {
                apiManagerInstance = ApiManager()
            }
            return apiManagerInstance!!
        }
    }

    fun <T> createService(clazz: Class<T>): T {
        val retrofit =
            getRetrofit(APP_URL.toHttpUrl(), getClient(HttpLoggingInterceptor.Level.BODY))
        return retrofit.create(clazz)
    }


    private fun getRetrofit(httpUrl: HttpUrl, client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(httpUrl)
            .addConverterFactory(MoshiConverterFactory.create(getMoshi()))
            .client(client)
            .build()
    }

    private fun getMoshi(): Moshi {
        return Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
    }

    private fun getClient(logLevel: HttpLoggingInterceptor.Level): OkHttpClient {
        val logging = HttpLoggingInterceptor()
        logging.level = logLevel
        return OkHttpClient()
            .newBuilder()
            .connectTimeout(3600, TimeUnit.SECONDS)
            .readTimeout(3600, TimeUnit.SECONDS)
            .addInterceptor(HeaderInterceptor())
            .addInterceptor(logging)
            .build()
    }
}