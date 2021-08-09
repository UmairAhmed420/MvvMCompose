package com.example.mvvmcompose

import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.compose.rememberNavController
import com.example.mvvmcompose.ui.theme.MvvMComposeTheme
import com.example.mvvmcompose.ui.viewmodel.CovidViewModel

@ExperimentalComposeUiApi
@Composable
fun CovidApp(covidViewModel: CovidViewModel) {
    MvvMComposeTheme {
        val navController = rememberNavController()
        CovidAppNavGraph(
            covidViewModel = covidViewModel,
            navController = navController
        )

    }
}