package com.whistle.loanmemoryapp.ui

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.whistle.loanmemoryapp.R
import com.whistle.loanmemoryapp.data.model.loans
import com.whistle.loanmemoryapp.ui.loan.LoanList


@Composable
fun Home(navController: NavController) {
    Surface(color = MaterialTheme.colorScheme.background) {
        LoanList(loans, navController)
    }
}

@Composable
fun Favorite() {

}

@Composable
fun Settings() {

}

enum class BottomNavScreens(val route: String, val icon: Int, val title: String) {
    Home("home", R.drawable.ic_home, "Home"),
    Favorite("favorite", R.drawable.ic_book, "Favorite"),
    Settings("settings", R.drawable.ic_settings, "Settings")
}
