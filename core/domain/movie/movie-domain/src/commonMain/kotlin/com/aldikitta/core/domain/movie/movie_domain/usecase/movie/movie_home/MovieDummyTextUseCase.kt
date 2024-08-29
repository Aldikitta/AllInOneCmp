package com.aldikitta.core.domain.movie.movie_domain.usecase.movie.movie_home

import com.aldikitta.core.domain.movie.movie_domain.repository.MovieRepository

class MovieDummyTextUseCase(
    private val movieRepository: MovieRepository
) {
    operator fun invoke(): String {
        return movieRepository.dummyTest()
    }
}