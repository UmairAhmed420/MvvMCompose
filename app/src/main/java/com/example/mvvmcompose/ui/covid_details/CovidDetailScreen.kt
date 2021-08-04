package com.example.mvvmcompose.ui.covid_details

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.example.mvvmcompose.ui.viewmodel.CovidViewModel

@Composable
fun CovidDetailScreen(
    navController: NavController,
    covidViewModel: CovidViewModel,
    countryName: String
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
//        covidViewModel.getCountryStats(countryName = countryName)
//        val response = covidViewModel.countriesListState.value
    }
}