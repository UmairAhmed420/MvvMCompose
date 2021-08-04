package com.example.mvvmcompose.ui.covid_details.model

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class StatsModel(
    @Json(name = "new") var newCases: String? = null,
    @Json(name = "active") var activeCases: Long? = null,
    @Json(name = "critical") var criticalCases: Long? = null,
    @Json(name = "1M_pop") var oneMPop: String? = null,
    @Json(name = "recovered") var recoveredCases: Long? = null,
    @Json(name = "total") var totalCases: Long? = null,
) : Parcelable
