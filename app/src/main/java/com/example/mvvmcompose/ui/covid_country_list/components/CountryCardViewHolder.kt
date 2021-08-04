package com.example.mvvmcompose.ui.covid_country_list.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CountryCardViewHolder(country: String, onClick: () -> Unit) {
    Card(
        shape = MaterialTheme.shapes.small,
        modifier = Modifier
            .fillMaxWidth(1f)

            .clickable(onClick = onClick),
        elevation = 8.dp

    ) {
        Text(
            text = country,
            modifier = Modifier
                .fillMaxWidth(1f)
                .padding(
                    start = 16.dp,
                    end = 16.dp,
                    top = 8.dp,
                    bottom = 8.dp
                )
                .wrapContentWidth(Alignment.Start),
            style = MaterialTheme.typography.h5
        )
    }
}