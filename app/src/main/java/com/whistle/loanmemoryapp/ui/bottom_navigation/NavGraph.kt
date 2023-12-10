package com.whistle.loanmemoryapp.ui.bottom_navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.whistle.loanmemoryapp.ui.Favorite
import com.whistle.loanmemoryapp.ui.Home
import com.whistle.loanmemoryapp.ui.Settings
import com.whistle.loanmemoryapp.ui.BottomNavScreens
import com.whistle.loanmemoryapp.ui.view.LoanDetailScreen


@Composable
fun NavGraph(
    navController: NavHostController
) {
    NavHost(navController, startDestination = BottomNavScreens.Home.route) {
        enumValues<BottomNavScreens>().forEach { item ->
            composable(item.route) {
                when(item.route) {
                    "home" -> Home(navController)
                    "favorite" -> Favorite()
                    "profile" -> Settings()
                }
            }

        }
        composable(route = "loan_detail") {
            LoanDetailScreen()
        }
    }
}
