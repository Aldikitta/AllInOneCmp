package usecase

import repository.MovieRepository

class MovieDummyTextUseCase(
    private val movieRepository: MovieRepository
) {
    operator fun invoke(): String {
        return movieRepository.dummyTest()
    }
}