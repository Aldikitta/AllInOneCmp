package com.aldikitta.core.domain.movie.movie_domain.di

import com.aldikitta.core.domain.movie.movie_domain.usecase.movie.movie_home.MovieDummyTextUseCase
import org.koin.dsl.module

val useCaseMovieModule = module {
    factory { MovieDummyTextUseCase(get()) }
}