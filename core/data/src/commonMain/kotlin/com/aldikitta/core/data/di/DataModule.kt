package com.aldikitta.core.data.di

import com.aldikitta.core.data.source.remote.client.MovieApiImpl
import com.aldikitta.core.data.source.remote.client.MovieClient
import com.aldikitta.core.domain.source.remote.MovieApi
import org.koin.dsl.module

val dataModule = module {
    single { MovieClient }
    single<MovieApi> { MovieApiImpl(get()) }
}