package com.example.shevtsov_pizza_shift_winter2026.presentation.ui

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun TextTitleLarge(
    text: String,
    modifier: Modifier = Modifier,
){
    Text(
        text = text,
        style = MaterialTheme.typography.titleLarge,
        modifier = modifier
    )
}