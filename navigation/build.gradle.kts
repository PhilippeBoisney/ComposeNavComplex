plugins {
    alias(libs.plugins.complexnav.android.library)
    id("kotlinx-serialization")
}

android {
    namespace = "com.complexnav.navigation"
}

dependencies {
    implementation(libs.kotlinx.serialization.json)
    implementation(libs.androidx.navigation.compose)
}
