package com.example.shevtsov_pizza_shift_winter2026.domain.usecase

import com.example.shevtsov_pizza_shift_winter2026.domain.model.Pizza
import com.example.shevtsov_pizza_shift_winter2026.domain.repository.PizzaRepository

class GetPizzasUseCase(
    private val repository: PizzaRepository
) {
    suspend operator fun invoke(): List<Pizza> {
        return repository.getPizzas()
    }
}