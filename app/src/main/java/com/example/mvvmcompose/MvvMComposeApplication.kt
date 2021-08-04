package com.example.mvvmcompose

import android.app.Application
import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.OnLifecycleEvent
import com.example.mvvmcompose.di.CovidModule
import com.example.mvvmcompose.di.NetworkModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MvvMComposeApplication : Application() {

    var isAppBackground = false
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@MvvMComposeApplication)
            modules(
                listOf(
                    CovidModule,
                    NetworkModule
                )
            )
        }
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun onAppBackgrounded() {
        Log.d("onAppBackground","SettingPrefrences")
        isAppBackground = true
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onAppForegrounded() {
        isAppBackground = false
    }
}