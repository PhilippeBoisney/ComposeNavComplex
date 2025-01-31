package com.complexnav.navigation

import kotlinx.serialization.Serializable

/**
 * All the possible "public" routes in the app.
 *
 * You can also split this sealed class to multiple sealed classes, inheriting from [Navigable]
 */
sealed class NavigableRoute : Navigable {
    // Main screen (containing 3 sub-screens)
    sealed class Home : NavigableRoute() {
        @Serializable data object Overview : Home()

        @Serializable data object Performance : Home()

        @Serializable data object Account : Home()
    }

    // Auth screens
    @Serializable data object Login : NavigableRoute()

    @Serializable data object Signup : NavigableRoute()

    // Product screen
    @Serializable data class Product(
        val name: String,
    ) : NavigableRoute()
}
