package com.whistle.loanmemoryapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.whistle.loanmemoryapp.ui.screens.MainScreen
import com.whistle.loanmemoryapp.ui.theme.LoanMemoryAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoanMemoryAppTheme {
                MainScreen(navController = rememberNavController())
            }
        }
    }
}
