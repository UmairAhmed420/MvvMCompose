package com.example.mvvmcompose.ui.covid_details

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.produceState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.example.mvvmcompose.data.model.response.BaseResponse
import com.example.mvvmcompose.ui.covid_details.model.CountryStatsResponse
import com.example.mvvmcompose.ui.viewmodel.CovidViewModel

@Composable
fun CovidDetailScreen(
    navController: NavController,
    name: String?,
    covidViewModel: CovidViewModel
) {
    produceState(initialValue = CountryStatsResponse(),name) {
        covidViewModel.getCovidCountryStats(name)
    }
    val countryStatsDetails = covidViewModel.countryStatsState.value
    val loading = covidViewModel.loading.value

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Green)
    ) {
        if (loading) {
            "Loading"
        } else {
            countryStatsDetails.let {
                it?.countryName?.let { name -> name }
            }
        }?.let {
            Text(
                text =
                it
            )
        }


//        covidViewModel.getCountryStats(countryName = countryName)
//        val response = covidViewModel.countriesListState.value
    }
}