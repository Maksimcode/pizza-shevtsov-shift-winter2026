package com.example.shevtsov_pizza_shift_winter2026.presentation.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.shevtsov_pizza_shift_winter2026.R
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.ui.unit.dp


@Composable
fun TextTitleMedium(
    text: String,
    modifier: Modifier = Modifier,
){
    Text(
        text = text,
        fontSize = 16.sp,
        color = MaterialTheme.colorScheme.onBackground,
        fontWeight = FontWeight.Medium,
        lineHeight = 24.sp,
        modifier = modifier,
    )
}

@Composable
fun TextDescriptionSmall(
    text: String,
    modifier: Modifier = Modifier,
){
    Text(
        text = text,
        fontSize = 12.sp,
        color = MaterialTheme.colorScheme.onSurface,
        fontWeight = FontWeight.Normal,
        lineHeight = 16.sp,
        modifier = modifier,
    )
}

@Composable
fun TextTitleBold(
    text: String,
    modifier: Modifier = Modifier,
){
    Text(
        text = text,
        fontSize = 24.sp,
        color = MaterialTheme.colorScheme.onBackground,
        fontWeight = FontWeight.Bold,
        lineHeight = 32.sp,
        modifier = modifier,
    )
}

@Composable
fun TextPriceFrom(
    text: String,
    modifier: Modifier = Modifier,
){
    Text(
        text = text,
        fontSize = 16.sp,
        color = MaterialTheme.colorScheme.onBackground,
        fontWeight = FontWeight.Medium,
        lineHeight = 24.sp,
        modifier = modifier,
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PizzaTopBar(
    showBackButton: Boolean,
    onBackClick: () -> Unit = {},
) {
    TopAppBar(
        modifier = Modifier.padding(start = 16.dp),
        title = {
            TextTitleBold(
                text = stringResource(R.string.pizza_header),
            )
        },
        navigationIcon = {
            if (showBackButton) {
                IconButton(onClick = onBackClick) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = stringResource(R.string.back_button_description),
                    )
                }
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.background,
            navigationIconContentColor = MaterialTheme.colorScheme.onBackground,
        ),
    )
}
