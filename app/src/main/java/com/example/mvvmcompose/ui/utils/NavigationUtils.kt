package com.example.mvvmcompose.ui.utils

sealed class NavigationUtils(
    val route: String
) {
    object CountryList : NavigationUtils("country_list")
    object CountryDetail : NavigationUtils("country_detail")

    companion object {
        const val COUNTRY_NAME_PARAMS = "country_name"
    }
}