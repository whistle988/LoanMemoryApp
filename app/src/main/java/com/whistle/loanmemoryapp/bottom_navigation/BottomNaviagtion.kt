package com.whistle.loanmemoryapp.bottom_navigation

import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun BottomNavigation(
    navController: NavHostController
) {
    val listItems = listOf(
        BottomItem.Home,
        BottomItem.Favorite,
        BottomItem.Profile
    )
    androidx.compose.material.BottomNavigation(
        backgroundColor = Color.White
    ) {
        val backStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = backStackEntry?.destination?.route
        listItems.forEach { item ->
            BottomNavigationItem(
                selected = currentRoute == item.route, 
                onClick = {
                    navController.navigate(item.route)
                },
                icon = { 
                    Icon(
                        painter = painterResource(id = item.icon), 
                        contentDescription = "Icon"
                    )
                },
                label = {
                    Text(
                        text = item.title,
                        fontSize = 9.sp
                    )
                },
                selectedContentColor = Color.Red,
                unselectedContentColor = Color.Gray
            )
        }
    }
}
