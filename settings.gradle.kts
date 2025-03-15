rootProject.name = "allinonecmp"
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
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
        maven("https://packages.jetbrains.team/maven/p/amper/amper")
        maven("https://www.jetbrains.com/intellij-repository/releases")
        maven("https://packages.jetbrains.team/maven/p/ij/intellij-dependencies")

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

plugins {
    // Add the plugin
    id("org.jetbrains.amper.settings.plugin").version("0.5.0")
}


include(":android-app")
include(":ios-app")
include(":shared")
include(":base:resources")
include(":base:navigation")
include(":base:utils")
include(":feature:dashboard")
include(":data:movie:movie-domain")
include(":data:movie:movie-data")