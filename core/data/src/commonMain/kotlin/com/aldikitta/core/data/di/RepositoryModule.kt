package com.aldikitta.core.data.di

import com.aldikitta.core.data.repository.MovieRepositoryImpl
import com.aldikitta.core.domain.repository.MovieRepository
import org.koin.dsl.module

val repositoryModule = module {
    factory<MovieRepository> {MovieRepositoryImpl(get(), get(), get(), get())}
}