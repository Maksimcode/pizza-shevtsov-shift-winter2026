package com.example.shevtsov_pizza_shift_winter2026.domain.model

fun Pizza.minPrice(): Double =
    ingredients.sumOf { it.price } + (sizes.minByOrNull { it.price }?.price ?: 0.0)