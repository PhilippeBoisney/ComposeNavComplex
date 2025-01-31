package com.features.product.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.complexnav.navigation.NavigableRoute
import com.complexnav.navigation.OnNavigateTo
import com.features.product.ProductScreen

fun NavGraphBuilder.productScreen(onNavigate: OnNavigateTo) {
    composable<NavigableRoute.Product> { backStackEntry ->
        val product: NavigableRoute.Product = backStackEntry.toRoute()
        ProductScreen(
            productName = product.name,
            onNavigate = onNavigate,
        )
    }
}
