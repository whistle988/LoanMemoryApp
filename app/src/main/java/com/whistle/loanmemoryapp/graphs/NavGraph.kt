package com.whistle.loanmemoryapp.graphs

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.whistle.loanmemoryapp.ui.Favorite
import com.whistle.loanmemoryapp.ui.Home
import com.whistle.loanmemoryapp.ui.Settings
import com.whistle.loanmemoryapp.ui.BottomNavScreens
import com.whistle.loanmemoryapp.ui.view.LoanDetailScreen


@Composable
fun NavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        route = Graph.HOME,
        startDestination = BottomNavScreens.Home.route
    ) {
        composable(route = BottomNavScreens.Home.route) {
            Home(navController)
        }
        composable(route = BottomNavScreens.Favorite.route) {
            Favorite()
        }
        composable(route = BottomNavScreens.Settings.route) {
            Settings(navController)
        }
        detailsNavGraph(navController = navController)
    }
}

fun NavGraphBuilder.detailsNavGraph(navController: NavHostController) {
    navigation(
        route = Graph.DETAILS,
        startDestination = DetailsScreen.Information.route
    ) {
        composable(route = DetailsScreen.Information.route) {
            LoanDetailScreen(navController)
        }
    }
}

sealed class DetailsScreen(val route: String) {
    object Information : DetailsScreen(route = "loan_detail")
}

object Graph {
    const val HOME = "home_graph"
    const val DETAILS = "details_graph"
}
