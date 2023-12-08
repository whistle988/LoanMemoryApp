package com.whistle.loanmemoryapp.ui

import android.annotation.SuppressLint
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
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.whistle.loanmemoryapp.bottom_navigation.BottomNavigation
import com.whistle.loanmemoryapp.bottom_navigation.NavGraph

@Preview
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen() {
    val navController = rememberNavController()
    Scaffold(
        topBar = {
            TopAppBar(

                title = {
                    Text(text = "LoanMemoryApp")
                },
                backgroundColor = Color.White,
                navigationIcon = {
                    IconButton(
                        onClick = { }
                    ) {
                        Icon(imageVector = Icons.Filled.Menu, 
                            contentDescription = "Menu")
                    }
                },
                actions = {
                    IconButton(
                        onClick = { /*TODO*/ }
                    ) {
                        Icon(imageVector = Icons.Filled.Add,
                            contentDescription = "Add")
                    }
                    IconButton(
                        onClick = { /*TODO*/ }
                    ) {
                        Icon(imageVector = Icons.Filled.Refresh,
                            contentDescription = "Add")
                    }
                    IconButton(
                        onClick = { /*TODO*/ }
                    ) {
                        Icon(imageVector = Icons.Filled.Search,
                            contentDescription = "Add")
                    }

                }
            )
        },
        bottomBar = {
            BottomNavigation(navController = navController)
        },
        content = {
            Column(modifier = Modifier.padding(it)) {
                NavGraph(navController = navController)
            }
        }
    )
}