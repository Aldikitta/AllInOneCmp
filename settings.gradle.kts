rootProject.name = "MovieKmp"
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
    includeBuild("build-logic")
    repositories {
        google {
            mavenContent {
                includeGroupAndSubgroups("androidx")
                includeGroupAndSubgroups("com.android")
                includeGroupAndSubgroups("com.google")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositories {
        google {
            mavenContent {
                includeGroupAndSubgroups("androidx")
                includeGroupAndSubgroups("com.android")
                includeGroupAndSubgroups("com.google")
            }
        }
        mavenCentral()
    }
}

include(":composeApp")
include(":feature:movie:movie-home")
include(":feature:movie:movie-detail")
include(":core:model")
include(":core:dto")
include(":core:mapper")
include(":feature:dashboard")
include(":base:navigation")
include(":core:data:movie:movie-data")
include(":core:domain:movie:movie-domain")
include(":core:common")
