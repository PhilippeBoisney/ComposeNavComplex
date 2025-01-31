package com.complexnav.navigation

import kotlinx.serialization.Serializable

sealed class NavigableGraph : Navigable {
    @Serializable data object Home : NavigableGraph()

    @Serializable data object Onboarding : NavigableGraph()
}
