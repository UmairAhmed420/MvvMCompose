package com.example.mvvmcompose.ui.covid_country_list

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.mvvmcompose.ui.covid_country_list.components.CountryCardViewHolder
import com.example.mvvmcompose.ui.utils.BottomNavigationUtils
import com.example.mvvmcompose.ui.viewmodel.CovidViewModel

@Composable
@ExperimentalComposeUiApi
fun CountryScreen(navController: NavController, covidViewModel: CovidViewModel) {

    val searchQuery = covidViewModel.searchQuery.value
    val countryList = covidViewModel.countriesListState.value
    Box(
        modifier = Modifier
            .fillMaxSize(1f)
            .background(Color.LightGray)
    ) {
        Column {
            SearchBar(
                searchQuery = searchQuery,
                onSearchQueryChange = covidViewModel::onSearchQueryChange,
                searchCountry = covidViewModel::searchCountry,
                getCountriesList = covidViewModel::getCountriesList
            )
            LazyColumn(
                modifier = Modifier.padding(top = 8.dp, bottom = 8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp),
                contentPadding = PaddingValues(
                    start = 8.dp,
                    end = 8.dp
                )
            ) {
                itemsIndexed(items = countryList)
                { index, item ->
                    CountryCardViewHolder(country = item, onClick = {
                        navController
                            .navigate("${BottomNavigationUtils.CountryDetail.route}/$item")
                    })

                }
            }
        }

    }

}


@ExperimentalComposeUiApi
@Composable
private fun SearchBar(
    searchQuery: String,
    onSearchQueryChange: (newValue: String) -> Unit,
    searchCountry: (searchQuery: String) -> Unit,
    getCountriesList: () -> Unit
) {

    val keyboardController = LocalSoftwareKeyboardController.current

    Surface(
        modifier = Modifier
            .fillMaxWidth(),
        elevation = 8.dp,
        color = MaterialTheme.colors.background
    ) {
        TextField(
            modifier = Modifier
                .fillMaxWidth(1f)
                .background(MaterialTheme.colors.background),
            value = searchQuery,
            onValueChange = { newValue ->
                onSearchQueryChange(newValue)
            },
            label = {
                Text(
                    text = "Search",
                    style = TextStyle(color = Color.DarkGray)
                )
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Search
            ),
            keyboardActions = KeyboardActions(onSearch = {
                keyboardController?.hide()
                if (searchQuery.isNotEmpty()) {
                    searchCountry(searchQuery)
                } else {
                    getCountriesList()
                }
            }),
            leadingIcon = {
                Icon(
                    imageVector = Icons.Filled.Search,
                    contentDescription = "search field"
                )
            },
            singleLine = true
        )
    }

}
