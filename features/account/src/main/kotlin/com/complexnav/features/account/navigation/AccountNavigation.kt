package com.complexnav.features.account.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.complexnav.features.account.ui.AccountScreen
import com.complexnav.navigation.NavigableRoute
import com.complexnav.navigation.OnNavigateTo

fun NavGraphBuilder.accountScreen(onNavigate: OnNavigateTo) {
    composable<NavigableRoute.Home.Account> {
        AccountScreen(onNavigate)
    }
}
