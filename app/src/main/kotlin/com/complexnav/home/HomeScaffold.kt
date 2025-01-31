package com.complexnav.home

import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteDefaults
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.complexnav.features.account.navigation.accountScreen
import com.complexnav.features.overview.navigation.overviewScreen
import com.complexnav.features.performance.navigation.performanceScreen
import com.complexnav.navigation.NavigableRoute
import com.complexnav.navigation.OnNavigateTo

@Composable
internal fun HomeScaffold(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    onNavigate: OnNavigateTo,
) {
    val currentBackStack by navController.currentBackStackEntryAsState()
    val currentDestination = currentBackStack?.destination
    val currentScreen =
        items
            .find { currentDestination?.hasRoute(it::class) == true }
            ?: NavigableRoute.Home.Overview

    val navigationSuiteItemColors =
        NavigationSuiteDefaults.itemColors(
            navigationBarItemColors =
            NavigationBarItemDefaults.colors(
                indicatorColor = Color.Transparent,
                selectedIconColor = MaterialTheme.colorScheme.primary,
            ),
        )

    NavigationSuiteScaffold(
        modifier = modifier,
        navigationSuiteItems = {
            items.forEach { item ->
                item(
                    icon = {
                        Icon(
                            imageVector = item.icon,
                            contentDescription = null,
                        )
                    },
                    selected = item == currentScreen,
                    onClick = {
                        navController.navigate(item) {
                            popUpTo(navController.graph.findStartDestination().id) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    },
                    colors = navigationSuiteItemColors,
                )
            }
        },
    ) {
        NavHost(
            navController = navController,
            startDestination = NavigableRoute.Home.Overview,
            modifier = Modifier.systemBarsPadding(),
        ) {
            overviewScreen(onNavigate)
            performanceScreen(onNavigate)
            accountScreen(onNavigate)
        }
    }
}

private val items =
    listOf(
        NavigableRoute.Home.Overview,
        NavigableRoute.Home.Performance,
        NavigableRoute.Home.Account,
    )

private val NavigableRoute.Home.icon
    get() =
        when (this) {
            is NavigableRoute.Home.Overview -> Icons.Default.Home
            is NavigableRoute.Home.Performance -> Icons.Default.Menu
            is NavigableRoute.Home.Account -> Icons.Default.AccountBox
        }
