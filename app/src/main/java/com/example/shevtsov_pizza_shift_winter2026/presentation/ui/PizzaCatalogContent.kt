package com.example.shevtsov_pizza_shift_winter2026.presentation.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.shevtsov_pizza_shift_winter2026.domain.model.Pizza

@Composable
fun PizzaCatalogContent(
    pizzas: List<Pizza>,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier.fillMaxSize(),
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(pizzas) { pizza ->
            PizzaItem(pizza = pizza)
        }
    }
}

@Composable
private fun PizzaItem(pizza: Pizza) {
    Card(
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = pizza.name,
                style = MaterialTheme.typography.titleLarge
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = pizza.description,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}