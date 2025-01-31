plugins {
    alias(libs.plugins.complexnav.android.feature)
    alias(libs.plugins.complexnav.android.library.compose)
    id("kotlinx-serialization")
}

android {
    namespace = "com.complexnav.features.onboarding"
}

dependencies {
    implementation(libs.kotlinx.serialization.json)
}
