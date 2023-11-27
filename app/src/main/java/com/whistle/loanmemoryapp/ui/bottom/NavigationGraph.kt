package com.whistle.loanmemoryapp.ui.bottom

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(navController, startDestination = Destinations.HomeScreen.route) {
        composable(Destinations.HomeScreen.route) {
            HomeScreen()
        }
        composable(Destinations.Favourite.route) {
            FavouriteScreen()
        }
        composable(Destinations.Notification.route) {
            NotificationScreen()
        }
    }
}