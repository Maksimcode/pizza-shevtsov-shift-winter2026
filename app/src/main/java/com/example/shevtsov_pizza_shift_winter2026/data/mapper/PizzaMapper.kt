package com.example.shevtsov_pizza_shift_winter2026.data.mapper

import com.example.shevtsov_pizza_shift_winter2026.data.dto.CatalogResponseDto
import com.example.shevtsov_pizza_shift_winter2026.data.dto.DoughDto
import com.example.shevtsov_pizza_shift_winter2026.data.dto.IngredientDto
import com.example.shevtsov_pizza_shift_winter2026.data.dto.PizzaDto
import com.example.shevtsov_pizza_shift_winter2026.data.dto.SizeDto
import com.example.shevtsov_pizza_shift_winter2026.data.dto.ToppingDto
import com.example.shevtsov_pizza_shift_winter2026.domain.model.Dough
import com.example.shevtsov_pizza_shift_winter2026.domain.model.DoughType
import com.example.shevtsov_pizza_shift_winter2026.domain.model.Ingredient
import com.example.shevtsov_pizza_shift_winter2026.domain.model.IngredientType
import com.example.shevtsov_pizza_shift_winter2026.domain.model.Pizza
import com.example.shevtsov_pizza_shift_winter2026.domain.model.Size
import com.example.shevtsov_pizza_shift_winter2026.domain.model.SizeType
import com.example.shevtsov_pizza_shift_winter2026.domain.model.Topping

fun CatalogResponseDto.toDomain(): List<Pizza> {
    return catalog.map { it.toDomain() }
}

fun PizzaDto.toDomain(): Pizza {
    return Pizza(
        id = id,
        name = name,
        ingredients = ingredients.map { it.toIngredient() },
        toppings = toppings.map { it.toTopping() },
        description = description,
        sizes = sizes.map { it.toDomain() },
        doughs = doughs.map { it.toDomain() },
        calories = calories,
        protein = protein,
        totalFat = totalFat,
        carbohydrates = carbohydrates,
        sodium = sodium,
        allergens = allergens,
        isVegetarian = isVegetarian,
        isGlutenFree = isGlutenFree,
        isNew = isNew,
        isHit = isHit,
        img = img
    )
}

fun IngredientDto.toIngredient(): Ingredient {
    return Ingredient(
        type = type.toIngredientType(),
        price = price,
        img = img
    )
}

fun ToppingDto.toTopping(): Topping {
    return Topping(
        type = type.toIngredientType(),
        price = price,
        img = img
    )
}

fun SizeDto.toDomain(): Size {
    return Size(
        type = type.toSizeType(),
        price = price
    )
}

fun DoughDto.toDomain(): Dough {
    return Dough(
        type = type.toDoughType(),
        price = price
    )
}

private fun String.toIngredientType(): IngredientType {
    return try {
        IngredientType.valueOf(this)
    } catch (e: IllegalArgumentException) {
        throw IllegalArgumentException("Неизвестный тип ингредиента: $this", e)
    }
}

private fun String.toSizeType(): SizeType {
    return try {
        SizeType.valueOf(this)
    } catch (e: IllegalArgumentException) {
        throw IllegalArgumentException("Неизвестный тип размера: $this", e)
    }
}

private fun String.toDoughType(): DoughType {
    return try {
        DoughType.valueOf(this)
    } catch (e: IllegalArgumentException) {
        throw IllegalArgumentException("Неизвестный тип толщины: $this", e)
    }
}
