package com.example.shevtsov_pizza_shift_winter2026.presentation.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.shevtsov_pizza_shift_winter2026.R
import com.example.shevtsov_pizza_shift_winter2026.presentation.ui.components.TextTitleMedium

@Composable
fun ProfileScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        TextTitleMedium(text = stringResource(R.string.bottom_nav_profile))
    }
}