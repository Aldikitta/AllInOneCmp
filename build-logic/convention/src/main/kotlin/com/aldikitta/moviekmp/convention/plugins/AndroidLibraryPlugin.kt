import com.android.build.api.dsl.LibraryExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.getByType

class AndroidLibraryPlugin : Plugin<Project> {
    override fun apply(target: Project):Unit = with(target){
        with(pluginManager) {
            apply(pluginLibs.findPlugin("androidLibrary").get().get().pluginId)
        }
        val extension = extensions.getByType<LibraryExtension>()
            configureKotlinAndroid(extension)
        }
    }