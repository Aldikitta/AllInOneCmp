package com.aldikitta.base.navigation

import kotlinx.serialization.Serializable

object Routes {
    const val INITIAL = "initial"
    const val MOVIE_DETAIL_SCREEN = "movie_detail_screen_routes"
    const val MOVIE_HOME_SCREEN = "movie_home_screen_routes"
    const val DASHBOARD = "dashboard_routes"
}

/*
* Dashboard Navigation Graph
* */
@Serializable
object DashboardNavGraph
@Serializable
object DashboardScreen

/*
* Movie Navigation Graph
* */
@Serializable
object MovieNavGraph
@Serializable
object MovieHomeScreen
@Serializable
object MovieDetailScreen