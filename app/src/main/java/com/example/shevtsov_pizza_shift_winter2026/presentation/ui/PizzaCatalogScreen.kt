package com.example.shevtsov_pizza_shift_winter2026.presentation.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.shevtsov_pizza_shift_winter2026.presentation.state.PizzaCatalogState
import com.example.shevtsov_pizza_shift_winter2026.presentation.viewmodel.PizzaCatalogViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun PizzaCatalogScreen(
    modifier: Modifier = Modifier,
    viewModel: PizzaCatalogViewModel = koinViewModel(),
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