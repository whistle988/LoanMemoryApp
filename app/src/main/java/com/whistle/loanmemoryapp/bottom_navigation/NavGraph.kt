package com.whistle.loanmemoryapp.bottom_navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun NavGraph(
    navController: NavHostController
) {
    NavHost(navController, startDestination = BottomItem.Home.route) {
        enumValues<BottomItem>().forEach { item ->
            composable(item.route) {
                when(item.route) {
                    "home" -> Home()
                    "favorite" -> Favorite()
                    "profile" -> Profile()
                }
            }
        }
    }
}