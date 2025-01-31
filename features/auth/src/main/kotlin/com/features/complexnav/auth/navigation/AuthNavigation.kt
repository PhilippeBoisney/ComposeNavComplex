package com.features.complexnav.auth.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.complexnav.navigation.NavigableRoute
import com.complexnav.navigation.OnNavigateTo
import com.features.complexnav.auth.LoginScreen
import com.features.complexnav.auth.SignupScreen

fun NavGraphBuilder.authScreens(onNavigate: OnNavigateTo) {
    composable<NavigableRoute.Signup> {
        SignupScreen(onNavigate)
    }

    composable<NavigableRoute.Login> {
        LoginScreen(onNavigate)
    }
}
