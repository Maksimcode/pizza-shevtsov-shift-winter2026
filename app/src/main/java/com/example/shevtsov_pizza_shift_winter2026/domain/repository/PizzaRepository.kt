package com.example.shevtsov_pizza_shift_winter2026.domain.repository

import com.example.shevtsov_pizza_shift_winter2026.domain.model.Pizza

interface PizzaRepository {
    suspend fun getPizzas(): List<Pizza>
}