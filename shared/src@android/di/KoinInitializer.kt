package di

import android.content.Context
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin

actual class KoinInitializer(
    private val context: Context
) {
    actual fun init() {
        startKoin {
            androidContext(context)
            androidLogger()
            modules(dataMovieModule)
        }
    }
}