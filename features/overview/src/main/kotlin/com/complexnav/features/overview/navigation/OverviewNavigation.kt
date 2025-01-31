package com.complexnav.features.overview.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.complexnav.features.overview.ui.OverviewScreen
import com.complexnav.navigation.NavigableRoute
import com.complexnav.navigation.OnNavigateTo

fun NavGraphBuilder.overviewScreen(onNavigate: OnNavigateTo) {
    composable<NavigableRoute.Home.Overview> {
        OverviewScreen(onNavigate)
    }
}
