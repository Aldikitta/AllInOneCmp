plugins {
    `kotlin-dsl`
}

group = "com.aldikitta.moviekmp.buildlogic" //your module name

dependencies {
    compileOnly(libs.android.gradlePlugin) //if targetting Android
    compileOnly(libs.kotlin.gradlePlugin)
    compileOnly(libs.compose.gradlePlugin) //if you are using Compose Multiplatform
}

gradlePlugin {
    plugins {
        register("androidApplication") {
            id = "moviekmp.android.application"
            implementationClass = "AndroidApplicationPlugin"
        }
        register("androidLibrary") {
            id = "moviekmp.android.library"
            implementationClass = "AndroidLibraryPlugin"
        }
        register("kotlinMultiplatform") {
            id = "moviekmp.multiplatform"
            implementationClass = "KotlinMultiplatformPlugin"
        }
    }
}