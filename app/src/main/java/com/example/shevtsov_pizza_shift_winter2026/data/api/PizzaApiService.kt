package com.example.shevtsov_pizza_shift_winter2026.data.api

import com.example.shevtsov_pizza_shift_winter2026.data.dto.CatalogResponseDto
import retrofit2.http.GET

interface PizzaApiService {
    @GET("catalog")
    suspend fun getPizzas(): CatalogResponseDto
}