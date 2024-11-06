plugins {
    id("moviekmp.android.application")
    id("moviekmp.multiplatform")
    kotlin("plugin.serialization") version "2.0.0"
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(project(":base:navigation"))
            implementation(project(":core:data:movie:movie-data"))
            implementation(project(":core:domain:movie:movie-domain"))
            implementation(project(":feature:dashboard"))
            implementation(project(":feature:movie:movie-home"))
            implementation(project(":feature:movie:movie-detail"))
            implementation(libs.kotlinx.serialization.json)
            implementation(libs.navigation.compose)
        }
    }
}

android {
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    dependencies {
        debugImplementation(libs.compose.ui.tooling)
    }
}

