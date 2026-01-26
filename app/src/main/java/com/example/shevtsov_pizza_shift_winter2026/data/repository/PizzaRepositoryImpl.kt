package com.example.shevtsov_pizza_shift_winter2026.data.repository

import com.example.shevtsov_pizza_shift_winter2026.data.api.PizzaApiService
import com.example.shevtsov_pizza_shift_winter2026.data.mapper.toDomain
import com.example.shevtsov_pizza_shift_winter2026.domain.model.Pizza
import com.example.shevtsov_pizza_shift_winter2026.domain.repository.PizzaRepository

class PizzaRepositoryImpl(
    private val api: PizzaApiService
) : PizzaRepository {

    override suspend fun getPizzas(): List<Pizza> {
        val response = api.getPizzas()
        return response.toDomain()
    }
}
