package com.complexnav

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import com.complexnav.home.HomeScaffold
import com.complexnav.navigation.Navigable
import com.complexnav.navigation.NavigableGraph
import com.complexnav.navigation.PreviousScreen
import com.features.complexnav.auth.navigation.authScreens
import com.features.onboarding.navigation.onBoardingGraph
import com.features.product.navigation.productScreen

@Composable
fun MainNavGraph(
    navController: NavHostController = rememberNavController(),
    startDestination: NavigableGraph = NavigableGraph.Home,
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
    ) {
        // Home page
        composable<NavigableGraph.Home> {
            HomeScaffold { destination, optionsBuilder ->
                navController.navigateTo(destination, navOptions(optionsBuilder))
            }
        }

        // Onboarding screens (graph)
        onBoardingGraph(navController)

        // Auth screens
        authScreens { destination, optionsBuilder ->
            navController.navigateTo(destination, navOptions(optionsBuilder))
        }

        // Product screen
        productScreen { destination, optionsBuilder ->
            navController.navigateTo(destination, navOptions(optionsBuilder))
        }
    }
}

private fun NavHostController.navigateTo(
    destination: Navigable,
    navOptions: NavOptions?,
) {
    when (destination) {
        is PreviousScreen -> {
            val isBackStackEmpty = previousBackStackEntry == null
            if (!isBackStackEmpty) popBackStack()
        }
        else -> navigate(destination, navOptions)
    }
}
