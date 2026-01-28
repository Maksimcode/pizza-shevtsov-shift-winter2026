package com.example.shevtsov_pizza_shift_winter2026

import android.app.Application
import com.example.shevtsov_pizza_shift_winter2026.data.network.networkModule
import com.example.shevtsov_pizza_shift_winter2026.di.pizzaModule
import com.example.shevtsov_pizza_shift_winter2026.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
            modules(
                networkModule,
                pizzaModule,
                viewModelModule,
            )
        }
    }
}