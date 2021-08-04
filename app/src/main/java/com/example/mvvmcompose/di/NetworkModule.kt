package com.example.mvvmcompose.di

import com.example.mvvmcompose.data.remoteapi.ApiManager
import com.example.mvvmcompose.data.remoteapi.CovidApi
import com.example.mvvmcompose.data.repository.CovidRepository
import org.koin.dsl.module

val NetworkModule = module {
    single { createCovidApi() }
    single { CovidRepository(covidApi = get()) }
}

fun createCovidApi(): CovidApi {
    return ApiManager.getApiManagerInstance().createService(CovidApi::class.java)
}