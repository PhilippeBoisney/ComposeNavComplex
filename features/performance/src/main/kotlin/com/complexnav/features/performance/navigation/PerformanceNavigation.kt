package com.complexnav.features.performance.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.complexnav.features.performance.ui.PerformanceScreen
import com.complexnav.navigation.NavigableRoute
import com.complexnav.navigation.OnNavigateTo

fun NavGraphBuilder.performanceScreen(onNavigate: OnNavigateTo) {
    composable<NavigableRoute.Home.Performance> {
        PerformanceScreen(onNavigate)
    }
}
