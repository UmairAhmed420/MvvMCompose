package com.example.mvvmcompose.data.repository

import com.example.mvvmcompose.data.remoteapi.CovidApi

class CovidRepository(private val covidApi: CovidApi) {

    suspend fun getCountries() = covidApi.getCountries()

    suspend fun searchCountry(query: String) = covidApi.searchCountry(query)

    suspend fun countryStats(countryName: String) =
        covidApi.countryStatistics(countryName = countryName)
}