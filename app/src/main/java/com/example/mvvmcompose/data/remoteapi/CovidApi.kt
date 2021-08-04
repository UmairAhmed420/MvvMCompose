package com.example.mvvmcompose.data.remoteapi

import com.example.mvvmcompose.data.model.response.BaseResponse
import com.example.mvvmcompose.data.remoteapi.ApiConstants.Endpoints.COUNTRIES
import com.example.mvvmcompose.data.remoteapi.ApiConstants.Endpoints.STATISTICS
import com.example.mvvmcompose.ui.covid_details.model.CountryStatsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface CovidApi {

    @GET("$COUNTRIES")
    suspend fun getCountries(): BaseResponse<MutableList<String>>

    @GET("$COUNTRIES")
    suspend fun searchCountry(@Query(ApiConstants.PARAMS.SEARCH) query: String): BaseResponse<MutableList<String>>


    @GET("$STATISTICS")
    suspend fun countryStatistics(@Query(ApiConstants.PARAMS.COUNTRY_NAME) countryName: String): BaseResponse<MutableList<CountryStatsResponse>>
}