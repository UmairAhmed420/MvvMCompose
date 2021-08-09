package com.example.mvvmcompose.ui.viewmodel

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvmcompose.data.repository.CovidRepository
import com.example.mvvmcompose.ui.covid_details.model.CountryStatsResponse
import kotlinx.coroutines.launch


class CovidViewModel
constructor(
    private val covidRepository: CovidRepository
) : ViewModel() {
    val countriesListState:
            MutableState<MutableList<String>> = mutableStateOf(mutableListOf())
    val countryStatsState:
            MutableState<CountryStatsResponse> = mutableStateOf(CountryStatsResponse())
    val searchQuery = mutableStateOf("")
    val loading = mutableStateOf(true)

    init {
        getCountriesList()
    }

    fun getCountriesList() {
        viewModelScope.launch {
            try {
                val data = covidRepository.getCountries()
                data.response?.let {
                    countriesListState.value = it
                }
            } catch (e: Exception) {
                Log.e("ApiError", e.localizedMessage)
            }
        }
    }

    fun onSearchQueryChange(newValue: String) {
        searchQuery.value = newValue
    }

    fun searchCountry(searchValue: String) {
        viewModelScope.launch {
            try {
                val data = covidRepository.searchCountry(searchValue)
                data.response?.let {
                    countriesListState.value = it
                }
            } catch (e: Exception) {
                Log.e("ApiError", e.localizedMessage)
            }


        }
    }


    fun getCovidCountryStats(countryName: String?) {
        loading.value = true
        viewModelScope.launch {
            try {
                val data = covidRepository.countryStats(countryName)

                data.response?.get(0)?.let {
                    countryStatsState.value = it
                }
                loading.value = false
            } catch (e: Exception) {
                loading.value = false
                Log.e("ApiError", e.localizedMessage)
            }
        }
    }
}

