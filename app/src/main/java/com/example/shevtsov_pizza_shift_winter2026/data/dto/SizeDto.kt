package com.example.shevtsov_pizza_shift_winter2026.data.dto

import com.example.shevtsov_pizza_shift_winter2026.domain.model.SizeType

data class SizeDto(
    val type: SizeType,
    val price: Double
)