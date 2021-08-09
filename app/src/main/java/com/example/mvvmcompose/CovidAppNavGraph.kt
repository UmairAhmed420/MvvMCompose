package com.example.mvvmcompose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import com.example.mvvmcompose.ui.covid_country_list.CountryScreen
import com.example.mvvmcompose.ui.covid_details.CovidDetailScreen
import com.example.mvvmcompose.ui.utils.NavigationUtils
import com.example.mvvmcompose.ui.utils.NavigationUtils.Companion.COUNTRY_NAME_PARAMS
import com.example.mvvmcompose.ui.viewmodel.CovidViewModel


@ExperimentalComposeUiApi
@Composable
fun CovidAppNavGraph(
    covidViewModel: CovidViewModel,
    navController: NavHostController = rememberNavController(),
    startDestination: String = NavigationUtils.CountryList.route
) {

    val actions = remember(navController) { MainActions(navController) }

    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(NavigationUtils.CountryList.route) {
            CountryScreen(
                navigateToCountryStats = actions.navigateToCountryStats,
                covidViewModel = covidViewModel
            )
        }
        composable(
            "${NavigationUtils.CountryDetail.route}/{$COUNTRY_NAME_PARAMS}",
            arguments = mutableListOf(
                navArgument(COUNTRY_NAME_PARAMS) { type = NavType.StringType }
            )
        ) { backStackEntry ->
            CovidDetailScreen(
                navController = navController,
                name = backStackEntry.arguments?.getString(COUNTRY_NAME_PARAMS),
                covidViewModel = covidViewModel
            )
        }
    }
}

class MainActions(navController: NavHostController) {
    val navigateToCountryStats: (String) -> Unit = { countryName: String ->
        navController.navigate("${NavigationUtils.CountryDetail.route}/$countryName")
    }

    //forBackPressOnClick
    val upPress: () -> Unit = {
        navController.navigateUp()
    }
}