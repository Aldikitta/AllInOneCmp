package di

import org.koin.dsl.module
import repository.MovieRepository
import repository.MovieRepositoryImpl

val dataMovieModule = module {
    factory<MovieRepository> { MovieRepositoryImpl() }
}
