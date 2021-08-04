package com.example.mvvmcompose.ui.covid_details.model

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CountryStatsResponse(
    @Json(name = "continent") var continent: String? = null,
    @Json(name = "country") var countryName: String? = null,
    @Json(name = "population") var countryPopulation: Long? = null,
    @Json(name = "cases") var casesStats: StatsModel? = null,
    @Json(name = "deaths") var deathsStats: StatsModel? = null,
    @Json(name = "tests") var testsStats: StatsModel? = null,
    @Json(name = "day") var day: String? = null,
    @Json(name = "time") var time: String? = null
) : Parcelable {}