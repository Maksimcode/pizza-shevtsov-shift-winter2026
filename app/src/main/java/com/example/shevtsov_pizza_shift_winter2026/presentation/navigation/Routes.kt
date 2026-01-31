package com.example.shevtsov_pizza_shift_winter2026.presentation.navigation

const val CATALOG = "catalog"
const val CATALOG_DETAIL = "catalog/{pizzaId}"
const val ORDERS = "orders"
const val CART = "cart"
const val PROFILE = "profile"

fun catalogDetail(pizzaId: String) = "catalog/$pizzaId"