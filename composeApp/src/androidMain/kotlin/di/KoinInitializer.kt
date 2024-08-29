package di

import android.content.Context
import com.aldikitta.core.data.movie.movie_data.di.dataMovieModule
import com.aldikitta.core.domain.movie.movie_domain.di.useCaseMovieModule
import com.aldikitta.feature.movie.movie_home.di.viewModelMovieHomeModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

actual class KoinInitializer(
    private val context: Context
) {
    actual fun init() {
        startKoin {
            androidContext(context)
            androidLogger()
            modules(appModule, viewModelModule, dataMovieModule, useCaseMovieModule, viewModelMovieHomeModule)
        }
    }
}