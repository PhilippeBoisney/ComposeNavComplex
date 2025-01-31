package com.features.onboarding.navigation

import kotlinx.serialization.Serializable

internal sealed class OnboardingRoute {
    @Serializable
    data object Step1 : OnboardingRoute()

    @Serializable
    data object Step2 : OnboardingRoute()

    @Serializable
    data object Step3 : OnboardingRoute()
}
