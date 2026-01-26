package com.example.shevtsov_pizza_shift_winter2026.data.dto

data class CatalogResponseDto(
    val success: Boolean,
    val catalog: List<PizzaDto>
)