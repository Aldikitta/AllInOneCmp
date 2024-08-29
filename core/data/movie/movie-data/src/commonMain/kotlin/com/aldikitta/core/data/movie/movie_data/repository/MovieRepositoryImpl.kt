package com.aldikitta.core.data.movie.movie_data.repository

import com.aldikitta.core.data.movie.movie_data.api.MovieService
import com.aldikitta.core.domain.movie.movie_domain.repository.MovieRepository

internal class MovieRepositoryImpl() : MovieRepository {
    override fun dummyTest(): String {
        return "Aldi"
    }
}