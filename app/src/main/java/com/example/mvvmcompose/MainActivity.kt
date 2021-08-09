package com.example.mvvmcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.core.view.WindowCompat
import com.example.mvvmcompose.ui.theme.MvvMComposeTheme
import com.example.mvvmcompose.ui.viewmodel.CovidViewModel
import org.koin.android.ext.android.inject

class MainActivity : ComponentActivity() {
    private val covidViewModel: CovidViewModel by inject()

    @ExperimentalComposeUiApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            CovidApp(covidViewModel)
        }
    }
}

