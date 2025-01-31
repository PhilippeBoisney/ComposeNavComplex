package com.features.onboarding.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.complexnav.navigation.NavigableGraph
import com.features.onboarding.Step1Screen
import com.features.onboarding.Step2Screen
import com.features.onboarding.Step3Screen

fun NavGraphBuilder.onBoardingGraph(navController: NavController) =
    navigation<NavigableGraph.Onboarding>(
        startDestination = OnboardingRoute.Step1,
    ) {
        composable<OnboardingRoute.Step1> {
            Step1Screen(
                onNext = { navController.navigate(OnboardingRoute.Step2) },
                onCancel = { navController.popBackStack(NavigableGraph.Home, inclusive = false) },
            )
        }
        composable<OnboardingRoute.Step2> {
            Step2Screen(
                onNext = { navController.navigate(OnboardingRoute.Step3) },
                onBack = { navController.popBackStack() },
            )
        }
        composable<OnboardingRoute.Step3> {
            Step3Screen(
                onFinish = { navController.popBackStack(NavigableGraph.Home, inclusive = false) },
                onBack = { navController.popBackStack() },
            )
        }
    }
