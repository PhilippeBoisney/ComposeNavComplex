pluginManagement {
    includeBuild("build-logic")
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}

@Suppress("UnstableApiUsage")
dependencyResolutionManagement {
    repositoriesMode = RepositoriesMode.FAIL_ON_PROJECT_REPOS
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "ComplexNav"

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
include(":app")
include(":features:overview")
include(":features:performance")
include(":features:account")
include(":navigation")
include(":features:auth")
include(":features:onboarding")
include(":features:product")
