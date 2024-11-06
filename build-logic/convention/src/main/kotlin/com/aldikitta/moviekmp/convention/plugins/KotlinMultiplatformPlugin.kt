import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.getByType
import org.jetbrains.compose.ComposeExtension
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

class KotlinMultiplatformPlugin: Plugin<Project> {
    override fun apply(target: Project):Unit = with(target){
        with(pluginManager){
            apply(pluginLibs.findPlugin("kotlinMultiplatform").get().get().pluginId)
            apply(pluginLibs.findPlugin("jetbrainsCompose").get().get().pluginId)
            apply(pluginLibs.findPlugin("compose-compiler").get().get().pluginId)
        }

        val composeDeps = extensions.getByType<ComposeExtension>().dependencies

        extensions.configure<KotlinMultiplatformExtension> {
            configureKotlinMultiplatform(this)
            sourceSets.apply {
                androidMain.dependencies {
                    implementation(pluginLibs.findLibrary("compose-ui-tooling-preview").get())
                    implementation(pluginLibs.findLibrary("androidx-activity-compose").get())
                }
                commonMain.dependencies {
                    implementation(composeDeps.runtime)
                    implementation(composeDeps.foundation)
                    implementation(composeDeps.material3)
                    implementation(composeDeps.ui)
                    implementation(composeDeps.components.resources)
                    implementation(composeDeps.components.uiToolingPreview)
                }
            }
        }
    }
}