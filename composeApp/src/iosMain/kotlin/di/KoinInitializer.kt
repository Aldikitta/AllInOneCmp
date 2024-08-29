package di

import com.aldikitta.core.data.movie.movie_data.di.dataMovieModule
import com.aldikitta.core.domain.movie.movie_domain.di.useCaseMovieModule
import com.aldikitta.feature.movie.movie_home.di.viewModelMovieHomeModule
import org.koin.core.context.startKoin

actual class KoinInitializer {
    actual fun init() {
        startKoin {
            modules(appModule, viewModelModule, dataMovieModule, useCaseMovieModule, viewModelMovieHomeModule)
        }
    }
}