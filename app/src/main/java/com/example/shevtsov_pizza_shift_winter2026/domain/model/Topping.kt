package com.example.shevtsov_pizza_shift_winter2026.domain.model

data class Topping(
    val type: IngredientType,
    val price: Double,
    val img: String
)