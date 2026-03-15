package com.example.productbrowser.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.productbrowser.ui.product.ProductDetailScreen
import com.example.productbrowser.ui.product.ProductListScreen

@Composable
fun AppNavigation() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = ProductListRoute
    ) {

        composable<ProductListRoute> {

            ProductListScreen {
                navController.navigate(
                    ProductDetailRoute(it)
                )
            }
        }

        composable<ProductDetailRoute> { backStackEntry ->

            val route = backStackEntry.toRoute<ProductDetailRoute>()

            ProductDetailScreen(
                productId = route.productId
            )
        }
    }
}