package com.example.shevtsov_pizza_shift_winter2026.presentation.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.Alignment
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.shevtsov_pizza_shift_winter2026.di.PizzaProvider
import com.example.shevtsov_pizza_shift_winter2026.presentation.state.PizzaCatalogState
import com.example.shevtsov_pizza_shift_winter2026.presentation.viewmodel.PizzaCatalogViewModel

@Composable
fun PizzaCatalogScreen(
    modifier: Modifier = Modifier,
    viewModel: PizzaCatalogViewModel = viewModel {
        PizzaCatalogViewModel(PizzaProvider.getPizzasUseCase)
    },
) {
    val state by viewModel.state.observeAsState(PizzaCatalogState.Initial)

    LaunchedEffect(Unit) {
        viewModel.loadPizzas()
    }

    Column(modifier = modifier.fillMaxSize()) {
        when (val currentState = state) {
            is PizzaCatalogState.Initial,
            is PizzaCatalogState.Loading -> {
                FullScreenProgressIndicator()
            }

            is PizzaCatalogState.Error -> {
                PizzaCatalogError(
                    message = currentState.error,
                    onRetry = viewModel::loadPizzas
                )
            }

            is PizzaCatalogState.Content -> {
                PizzaCatalogContent(pizzas = currentState.pizzas)
            }
        }
    }
}

@Composable
private fun FullScreenProgressIndicator() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator()
    }
}