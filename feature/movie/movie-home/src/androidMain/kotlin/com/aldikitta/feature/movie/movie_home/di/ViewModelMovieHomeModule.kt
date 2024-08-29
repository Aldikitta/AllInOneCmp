package com.aldikitta.feature.movie.movie_home.di

import com.aldikitta.feature.movie.movie_home.viewmodel.MovieHomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

actual val viewModelMovieHomeModule = module {
    viewModelOf(::MovieHomeViewModel)
}