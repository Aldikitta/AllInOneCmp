package navigation.graph

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.compose.navigation
import com.aldikitta.base.navigation.MovieHomeScreen
import com.aldikitta.base.navigation.MovieNavGraph
import com.aldikitta.feature.movie.movie_home.navigation.movieHomeScreen

fun NavController.navigateToMovieNavGraph(navOptions: NavOptions? = null) {
    this.navigate(MovieNavGraph, navOptions)
}

fun NavGraphBuilder.movieNavGraph(
    navHostController: NavHostController
) {
    navigation<MovieNavGraph>(
        startDestination = MovieHomeScreen
    ) {
        movieHomeScreen{}
    }
}