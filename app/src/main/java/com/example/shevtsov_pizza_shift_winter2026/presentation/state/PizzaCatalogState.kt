package com.example.shevtsov_pizza_shift_winter2026.presentation.state

import com.example.shevtsov_pizza_shift_winter2026.domain.model.Pizza

sealed interface PizzaCatalogState {
    data object Initial : PizzaCatalogState
    data object Loading : PizzaCatalogState
    data class Error(val error: String) : PizzaCatalogState
    data class Content(val pizzas: List<Pizza>) : PizzaCatalogState
}