package com.whistle.loanmemoryapp.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.whistle.loanmemoryapp.R
import com.whistle.loanmemoryapp.ui.bottom_navigation.BottomNavigation
import com.whistle.loanmemoryapp.ui.bottom_navigation.Favorite
import com.whistle.loanmemoryapp.ui.bottom_navigation.Home
import com.whistle.loanmemoryapp.ui.bottom_navigation.Settings
import com.whistle.loanmemoryapp.ui.screens.LoanDetailScreen
import com.whistle.loanmemoryapp.ui.theme.LoanMemoryAppTheme
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoanMemoryAppTheme {
                val navController = rememberNavController()
                val mainViewModel: MainViewModel = hiltViewModel()
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
                Timber.d("mainViewModel = $mainViewModel")

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
                    }
                ) { innerPadding ->
                    NavHost(
                        navController = navController,
                        route = Graph.HOME,
                        startDestination = BottomNavScreens.Home.route,
                        modifier = Modifier.padding(innerPadding)
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
                        detailsNavGraph(navController = navController, mainViewModel = mainViewModel)
                    }
                }
            }
        }
    }
}

fun NavGraphBuilder.detailsNavGraph(navController: NavHostController, mainViewModel: MainViewModel) {
    navigation(
        route = Graph.DETAILS,
        startDestination = DetailsScreen.Information.route
    ) {
        composable(route = DetailsScreen.Information.route,
            arguments = listOf(
                navArgument(name = "id") {
                    type = NavType.IntType
                }
            )
        ) { index ->
            LoanDetailScreen(
                navController = navController,
                id = index.arguments?.getInt("id"),
                mainViewModel = mainViewModel
            )
        }
    }
}

sealed class DetailsScreen(val route: String) {
    object Information : DetailsScreen(route = "loan_detail/{id}")
}

enum class BottomNavScreens(val route: String, val icon: Int, val title: String) {
    Home("home", R.drawable.ic_home, "Home"),
    Favorite("favorite", R.drawable.ic_book, "Избранные"),
    Settings("settings", R.drawable.ic_settings, "Настройки")
}

object Graph {
    const val HOME = "home_graph"
    const val DETAILS = "details_graph"
}
