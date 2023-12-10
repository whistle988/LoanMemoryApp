package com.whistle.loanmemoryapp.ui.view

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
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.whistle.loanmemoryapp.R
import com.whistle.loanmemoryapp.ui.bottom_navigation.NavGraph
import com.whistle.loanmemoryapp.ui.bottom_navigation.BottomNavigation


@Preview
@Composable
fun MainScreen() {
    val bottomNavController = rememberNavController()
    var showTopBar by rememberSaveable {
        mutableStateOf(true)
    }
    var showBottomBar by rememberSaveable {
        mutableStateOf(true)
    }
    val navBackStackEntry by bottomNavController.currentBackStackEntryAsState()

    showTopBar = when (navBackStackEntry?.destination?.route) {
        "loan_detail" -> false
        "favorite" -> false
        "settings" -> false
        else -> true
    }
    showBottomBar = when (navBackStackEntry?.destination?.route) {
        "loan_detail" -> false
        else -> true
    }

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
                            onClick = { bottomNavController.navigate("loan_detail") }
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
            if (showBottomBar) BottomNavigation(navController = bottomNavController)
        },
        content = {
            Column(modifier = Modifier.padding(it)) {
                NavGraph(navController = bottomNavController)
            }
        }
    )
}
