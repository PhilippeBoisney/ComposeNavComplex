package com.complexnav.navigation

import kotlinx.serialization.Serializable

interface Navigable

@Serializable
data object PreviousScreen : Navigable
