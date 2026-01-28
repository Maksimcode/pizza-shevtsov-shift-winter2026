package com.example.shevtsov_pizza_shift_winter2026.data.dto

import com.example.shevtsov_pizza_shift_winter2026.domain.model.DoughType

data class DoughDto(
    val type: DoughType,
    val price: Double
)