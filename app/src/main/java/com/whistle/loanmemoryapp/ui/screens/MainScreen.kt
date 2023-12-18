package com.whistle.loanmemoryapp.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.whistle.loanmemoryapp.MainViewModel
import com.whistle.loanmemoryapp.R
import com.whistle.loanmemoryapp.graphs.DetailsScreen
import com.whistle.loanmemoryapp.graphs.NavGraph
import com.whistle.loanmemoryapp.ui.bottom_navigation.BottomNavScreens
import com.whistle.loanmemoryapp.ui.bottom_navigation.BottomNavigation


@Composable
fun MainScreen(
    mainViewModel: MainViewModel = hiltViewModel(),
    navController: NavHostController
) {
    val loanList = mainViewModel.loanList
    var showTopBar by rememberSaveable {
        mutableStateOf(true)
    }
    var showBottomBar by rememberSaveable {
        mutableStateOf(true)
    }
    val navBackStackEntry by navController.currentBackStackEntryAsState()

    showTopBar = when (navBackStackEntry?.destination?.route) {
        DetailsScreen.Information.route -> false
        BottomNavScreens.Favorite.route -> false
        BottomNavScreens.Settings.route -> false
        else -> true
    }
    showBottomBar = when (navBackStackEntry?.destination?.route) {
        DetailsScreen.Information.route -> false
        else -> true
    }

    mainViewModel.getAllItems()

    Scaffold(
        topBar = {
            if (showTopBar) {
                TopAppBar(
                    title = {
                        Text(text = "LoanMemoryApp")
                    },
                    backgroundColor = Color.White,
                    navigationIcon = {
                        IconButton(
                            onClick = { }
                        ) {
                            Icon(
                                imageVector = Icons.Filled.Menu,
                                contentDescription = "Menu"
                            )
                        }
                    },
                    actions = {
                        IconButton(
                            onClick = { navController.navigate(DetailsScreen.Information.route) }
                        ) {
                            Icon(
                                imageVector = Icons.Filled.Add,
                                contentDescription = "Add"
                            )
                        }
                        IconButton(
                            onClick = { /*TODO*/ }
                        ) {
                            Icon(
                                imageVector = Icons.Filled.Refresh,
                                contentDescription = "Add"
                            )
                        }
                        IconButton(
                            onClick = { /*TODO*/ }
                        ) {
                            Icon(
                                painterResource(id = R.drawable.ic_sort),
                                contentDescription = "Add"
                            )
                        }

                    }
                )
            }
        },
        bottomBar = {
            if (showBottomBar) BottomNavigation(navController = navController)
        },
        content = {
            Column(modifier = Modifier.padding(it)) {
                NavGraph(navController = navController, loanList)
            }
        }
    )
}
