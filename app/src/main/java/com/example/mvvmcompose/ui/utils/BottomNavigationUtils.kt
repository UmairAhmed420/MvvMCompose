package com.example.mvvmcompose.ui.utils

import androidx.annotation.DrawableRes

sealed class BottomNavigationUtils(
    val route: String
) {
    object CountryList : BottomNavigationUtils("country_list")
    object CountryDetail : BottomNavigationUtils("country_detail")
}