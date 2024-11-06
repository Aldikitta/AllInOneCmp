import com.android.build.api.dsl.ApplicationExtension
import configureKotlinAndroid
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

class AndroidApplicationPlugin : Plugin<Project> {
    override fun apply(target: Project):Unit = with(target){
        with(pluginManager) {
            apply(pluginLibs.findPlugin("androidApplication").get().get().pluginId)
        }
            extensions.configure<ApplicationExtension> {
                configureKotlinAndroid(this)

                defaultConfig {
                    applicationId = "com.aldikitta.moviekmp"
                    targetSdk = pluginLibs.findVersion("android-targetSdk").get().requiredVersion.toInt()
                    versionCode = 1
                    versionName = "1.0"
                }
            }
        }
    }