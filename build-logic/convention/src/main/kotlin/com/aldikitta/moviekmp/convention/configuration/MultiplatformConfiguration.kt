import org.gradle.api.Project
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension
import org.jetbrains.kotlin.gradle.tasks.KotlinJvmCompile

internal fun Project.configureKotlinMultiplatform(
    extension: KotlinMultiplatformExtension
) = extension.apply {
    val moduleName = path.substringAfter(":").replace(":", ".").replaceFirstChar { it.uppercase() }

    androidTarget {
        compilations.all {
            tasks.withType<KotlinJvmCompile>().configureEach {
                compilerOptions {
                    jvmTarget.set(JvmTarget.JVM_17)
                    freeCompilerArgs.add("-opt-in=kotlin.RequiresOptIn")
                }
            }
        }
    }

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = moduleName
            isStatic = true
        }
    }

    applyDefaultHierarchyTemplate()

    //common dependencies
    sourceSets.apply {
        commonMain {
            dependencies {
                implementation(pluginLibs.findLibrary("koin-core").get())
                implementation(pluginLibs.findLibrary("koin-compose").get())
            }
        }

        androidMain {
            dependencies {
                implementation(pluginLibs.findLibrary("koin.android").get() )
                implementation(pluginLibs.findLibrary("koin.androidx.compose").get() )
            }
        }

        commonTest.dependencies {
            //
        }
    }
}