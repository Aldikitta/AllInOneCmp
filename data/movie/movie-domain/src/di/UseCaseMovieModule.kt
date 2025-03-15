package di

import org.koin.dsl.module
import usecase.MovieDummyTextUseCase

val useCaseMovieModule = module {
    factory { MovieDummyTextUseCase(get()) }
}