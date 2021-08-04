package com.example.mvvmcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import com.example.mvvmcompose.ui.covid_country_list.CountryScreen
import com.example.mvvmcompose.ui.covid_details.CovidDetailScreen
import com.example.mvvmcompose.ui.theme.MvvMComposeTheme
import com.example.mvvmcompose.ui.utils.BottomNavigationUtils
import com.example.mvvmcompose.ui.viewmodel.CovidViewModel
import org.koin.android.ext.android.inject
import kotlin.reflect.typeOf

class MainActivity : ComponentActivity() {
    private val covidViewModel: CovidViewModel by inject()

    @ExperimentalComposeUiApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MvvMComposeTheme {
                BodyContent(covidViewModel)
            }
        }
    }
}

@ExperimentalComposeUiApi
@Composable
private fun BodyContent(covidViewModel: CovidViewModel) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = BottomNavigationUtils.CountryList.route
    ) {
        composable(BottomNavigationUtils.CountryList.route) {
            CountryScreen(navController, covidViewModel)
        }
        composable(
            "${BottomNavigationUtils.CountryDetail.route}/{country_name}",
            arguments = mutableListOf(
                navArgument("country_name") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            backStackEntry.arguments?.getString("country_name")?.let {
                CovidDetailScreen(
                    navController = navController,
                    covidViewModel = covidViewModel,
                    countryName = it
                )
            }

        }
    }
}