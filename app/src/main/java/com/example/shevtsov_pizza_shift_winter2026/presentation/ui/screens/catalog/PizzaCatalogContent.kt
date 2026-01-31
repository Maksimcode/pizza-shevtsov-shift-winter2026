package com.example.shevtsov_pizza_shift_winter2026.presentation.ui.screens.catalog

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.ImageLoader
import coil.compose.AsyncImage
import com.example.shevtsov_pizza_shift_winter2026.domain.model.Pizza
import com.example.shevtsov_pizza_shift_winter2026.domain.model.minPrice
import com.example.shevtsov_pizza_shift_winter2026.presentation.ui.components.TextDescriptionSmall
import com.example.shevtsov_pizza_shift_winter2026.presentation.ui.components.TextPriceFrom
import com.example.shevtsov_pizza_shift_winter2026.presentation.ui.components.TextTitleMedium
import org.koin.compose.koinInject

@Composable
fun PizzaCatalogContent(
    pizzas: List<Pizza>,
    modifier: Modifier = Modifier,
    onPizzaClick: (String) -> Unit = {},
) {
    LazyColumn(
        modifier = modifier.fillMaxSize(),
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(pizzas) { pizza ->
            PizzaItem(
                name = pizza.name,
                description = pizza.description,
                imageUrl = pizza.img,
                priceFrom = pizza.minPrice().toInt(),
                onClick = { onPizzaClick(pizza.id) }
            )
        }
    }
}

@Composable
private fun PizzaItem(
    name: String,
    description: String,
    imageUrl: String,
    priceFrom: Int,
    onClick: () -> Unit,
    imageLoader: ImageLoader = koinInject(),
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .padding(vertical = 12.dp),
    ) {
        AsyncImage(
            model = imageUrl,
            imageLoader = imageLoader,
            contentDescription = null,
            modifier = Modifier
                .size(116.dp)
        )

        Spacer(modifier = Modifier.width(20.dp))

        Column(
            modifier = Modifier
                .weight(1f),
        ) {
            TextTitleMedium(text = name)
            Spacer(modifier = Modifier.height(4.dp))
            TextDescriptionSmall(text = description)
            Spacer(modifier = Modifier.height(8.dp))
            TextPriceFrom(text = "от $priceFrom ₽")
        }
    }
}