package com.example.shevtsov_pizza_shift_winter2026.presentation.ui.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.shevtsov_pizza_shift_winter2026.R
import com.example.shevtsov_pizza_shift_winter2026.presentation.navigation.CART
import com.example.shevtsov_pizza_shift_winter2026.presentation.navigation.CATALOG
import com.example.shevtsov_pizza_shift_winter2026.presentation.navigation.CATALOG_DETAIL
import com.example.shevtsov_pizza_shift_winter2026.presentation.navigation.ORDERS
import com.example.shevtsov_pizza_shift_winter2026.presentation.navigation.PROFILE
import com.example.shevtsov_pizza_shift_winter2026.presentation.navigation.catalogDetail
import com.example.shevtsov_pizza_shift_winter2026.presentation.ui.components.PizzaTopBar
import com.example.shevtsov_pizza_shift_winter2026.presentation.ui.screens.CartScreen
import com.example.shevtsov_pizza_shift_winter2026.presentation.ui.screens.OrdersScreen
import com.example.shevtsov_pizza_shift_winter2026.presentation.ui.screens.PizzaDetailScreen
import com.example.shevtsov_pizza_shift_winter2026.presentation.ui.screens.ProfileScreen
import com.example.shevtsov_pizza_shift_winter2026.presentation.ui.screens.catalog.PizzaCatalogScreen
import com.example.shevtsov_pizza_shift_winter2026.ui.theme.BrandColor
import com.example.shevtsov_pizza_shift_winter2026.ui.theme.TextTertiaryLight

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = backStackEntry?.destination?.route

    val titleRes = when (currentRoute) {
        ORDERS -> R.string.bottom_nav_orders
        CART -> R.string.bottom_nav_cart
        PROFILE -> R.string.bottom_nav_profile
        else -> R.string.pizza_header
    }
    val showBackButton = currentRoute == CATALOG_DETAIL

    val showBottomBar = currentRoute in listOf(CATALOG, CATALOG_DETAIL, ORDERS, CART, PROFILE)

    val bottomItems = listOf(
        BottomNavItem(
            route = CATALOG,
            iconRes = R.drawable.ic_nav_menu,
            label = stringResource(R.string.bottom_nav_menu),
        ),
        BottomNavItem(
            route = ORDERS,
            iconRes = R.drawable.ic_nav_orders,
            label = stringResource(R.string.bottom_nav_orders),
        ),
        BottomNavItem(
            route = CART,
            iconRes = R.drawable.ic_nav_cart,
            label = stringResource(R.string.bottom_nav_cart),
        ),
        BottomNavItem(
            route = PROFILE,
            iconRes = R.drawable.ic_nav_profile,
            label = stringResource(R.string.bottom_nav_profile),
        ),
    )

    val selectedIndex = when (currentRoute) {
        CATALOG, CATALOG_DETAIL -> 0
        ORDERS -> 1
        CART -> 2
        PROFILE -> 3
        else -> 0
    }

    Scaffold(
        topBar = {
            PizzaTopBar(
                title = stringResource(titleRes),
                showBackButton = showBackButton,
                onBackClick = { navController.popBackStack() }
            )
        },
        bottomBar = {
            if (showBottomBar) {
                Column {
                    HorizontalDivider(
                        color = MaterialTheme.colorScheme.surfaceVariant,
                        thickness = 1.dp
                    )
                    NavigationBar(
                        containerColor = MaterialTheme.colorScheme.background,
                        tonalElevation = 0.dp,
                    ) {
                        bottomItems.forEachIndexed { index, item ->
                            val isSelected = selectedIndex == index
                            NavigationBarItem(
                                selected = isSelected,
                                onClick = {
                                    navController.navigate(item.route) {
                                        popUpTo(navController.graph.findStartDestination().id) {
                                            saveState = true
                                        }
                                        launchSingleTop = true
                                        restoreState = true
                                    }
                                },
                                colors = NavigationBarItemDefaults.colors(
                                    selectedIconColor = BrandColor,
                                    selectedTextColor = BrandColor,
                                    unselectedIconColor = TextTertiaryLight,
                                    unselectedTextColor = TextTertiaryLight,
                                    indicatorColor = Color.Transparent
                                ),
                                icon = {
                                    Icon(
                                        painter = painterResource(item.iconRes),
                                        contentDescription = item.label,
                                    )
                                },
                                label = { Text(item.label) },
                            )
                        }
                    }
                }
            }
        },
    ) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = CATALOG,
            modifier = Modifier.padding(paddingValues),
        ) {
            composable(CATALOG) {
                PizzaCatalogScreen(
                    onPizzaClick = { pizzaId ->
                        navController.navigate(catalogDetail(pizzaId))
                    },
                )
            }
            composable(
                route = CATALOG_DETAIL,
                arguments = listOf(navArgument("pizzaId") { type = NavType.StringType }),
            ) { entry ->
                val pizzaId = entry.arguments?.getString("pizzaId")
                PizzaDetailScreen(
                    pizzaId = pizzaId,
                    onBack = { navController.popBackStack() },
                )
            }
            composable(ORDERS) {
                OrdersScreen()
            }
            composable(CART) {
                CartScreen()
            }
            composable(PROFILE) {
                ProfileScreen()
            }
        }
    }
}

private data class BottomNavItem(
    val route: String,
    val iconRes: Int,
    val label: String,
)