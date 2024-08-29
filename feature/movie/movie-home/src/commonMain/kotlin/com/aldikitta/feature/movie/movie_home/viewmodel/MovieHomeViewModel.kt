package com.aldikitta.feature.movie.movie_home.viewmodel

import androidx.lifecycle.ViewModel
import com.aldikitta.core.domain.movie.movie_domain.usecase.movie.movie_home.MovieDummyTextUseCase

internal class MovieHomeViewModel(
    private val movieDummyTextUseCase: MovieDummyTextUseCase
) : ViewModel() {
    fun getMovieDummyText(): String {
        return movieDummyTextUseCase.invoke()
    }
}