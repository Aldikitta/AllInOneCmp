package di

import org.koin.core.annotation.Factory
import org.koin.core.annotation.Module
import repository.MovieRepository
import repository.MovieRepositoryImpl

@Module
class DataMovieModule {
    @Factory(binds = [MovieRepository::class])
    fun movieRepository() = MovieRepositoryImpl()

}