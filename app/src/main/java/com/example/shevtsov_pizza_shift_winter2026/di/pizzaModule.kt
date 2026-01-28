package com.example.shevtsov_pizza_shift_winter2026.di

import com.example.shevtsov_pizza_shift_winter2026.data.repository.PizzaRepositoryImpl
import com.example.shevtsov_pizza_shift_winter2026.domain.repository.PizzaRepository
import com.example.shevtsov_pizza_shift_winter2026.domain.usecase.GetPizzasUseCase
import org.koin.dsl.module

val pizzaModule = module {

    single<PizzaRepository> {
        PizzaRepositoryImpl(get())
    }

    single {
        GetPizzasUseCase(get())
    }
}