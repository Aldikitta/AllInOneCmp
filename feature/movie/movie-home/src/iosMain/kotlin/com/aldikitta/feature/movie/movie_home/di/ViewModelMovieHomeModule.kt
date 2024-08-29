package com.aldikitta.feature.movie.movie_home.di

import com.aldikitta.feature.movie.movie_home.viewmodel.MovieHomeViewModel
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

actual val viewModelMovieHomeModule = module {
    singleOf(::MovieHomeViewModel)
}