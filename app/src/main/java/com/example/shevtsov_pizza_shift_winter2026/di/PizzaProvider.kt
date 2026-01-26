package com.example.shevtsov_pizza_shift_winter2026.di

import com.example.shevtsov_pizza_shift_winter2026.data.api.PizzaApiService
import com.example.shevtsov_pizza_shift_winter2026.data.network.NetworkModule.retrofit
import com.example.shevtsov_pizza_shift_winter2026.data.repository.PizzaRepositoryImpl
import com.example.shevtsov_pizza_shift_winter2026.domain.repository.PizzaRepository
import com.example.shevtsov_pizza_shift_winter2026.domain.usecase.GetPizzasUseCase

object PizzaProvider {

    private val pizzaApi: PizzaApiService = retrofit.create(PizzaApiService::class.java)
    private val pizzaRepository: PizzaRepository = PizzaRepositoryImpl(pizzaApi)
    val getPizzasUseCase = GetPizzasUseCase(pizzaRepository)
}
