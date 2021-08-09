package com.example.mvvmcompose.di

import com.example.mvvmcompose.ui.viewmodel.CovidViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val CovidModule = module {
    viewModel { CovidViewModel(covidRepository = get()) }
}