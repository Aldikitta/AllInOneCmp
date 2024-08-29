package com.aldikitta.core.data.movie.movie_data.di

import com.aldikitta.core.data.movie.movie_data.repository.MovieRepositoryImpl
import com.aldikitta.core.domain.movie.movie_domain.repository.MovieRepository
import org.koin.dsl.module

val dataMovieModule = module {
    factory<MovieRepository> { MovieRepositoryImpl() }
}