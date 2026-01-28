package com.example.shevtsov_pizza_shift_winter2026.di

import com.example.shevtsov_pizza_shift_winter2026.presentation.viewmodel.PizzaCatalogViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    viewModel {
        PizzaCatalogViewModel(get())
    }
}