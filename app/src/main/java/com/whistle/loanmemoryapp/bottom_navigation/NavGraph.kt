package com.whistle.loanmemoryapp.bottom_navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.whistle.loanmemoryapp.ui.Favorite
import com.whistle.loanmemoryapp.ui.Home
import com.whistle.loanmemoryapp.ui.Profile

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