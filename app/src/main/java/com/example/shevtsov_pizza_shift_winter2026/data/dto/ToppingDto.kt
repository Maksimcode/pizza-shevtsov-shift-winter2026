package com.example.shevtsov_pizza_shift_winter2026.data.dto

import com.example.shevtsov_pizza_shift_winter2026.domain.model.IngredientType

data class ToppingDto(
    val type: IngredientType,
    val price: Double,
    val img: String
)