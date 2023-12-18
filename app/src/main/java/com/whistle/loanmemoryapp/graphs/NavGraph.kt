package com.whistle.loanmemoryapp.graphs

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.whistle.loanmemoryapp.data.model.Loan
import com.whistle.loanmemoryapp.ui.bottom_navigation.Favorite
import com.whistle.loanmemoryapp.ui.bottom_navigation.Home
import com.whistle.loanmemoryapp.ui.bottom_navigation.Settings
import com.whistle.loanmemoryapp.ui.bottom_navigation.BottomNavScreens


@Composable
fun NavGraph(
    navController: NavHostController,
    loanList: MutableState<List<Loan>>
) {
    NavHost(
        navController = navController,
        route = Graph.HOME,
        startDestination = BottomNavScreens.Home.route
    ) {
        composable(route = BottomNavScreens.Home.route) {
            Home(navController, loanList)
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
        composable(route = DetailsScreen.Information.route,
            arguments = listOf(
                navArgument(name = "name") {
                    type = NavType.StringType
                }
            )
        ) { index ->
            /*LoanDetailScreen(
                navController,
                name = index.arguments?.getString("name"),

            )*/
        }
    }
}

sealed class DetailsScreen(val route: String) {
    object Information : DetailsScreen(route = "loan_detail/{name}")
}

object Graph {
    const val HOME = "home_graph"
    const val DETAILS = "details_graph"
}
