package com.whistle.loanmemoryapp.bottom_navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.whistle.loanmemoryapp.data.model.loans
import com.whistle.loanmemoryapp.ui.loan.AllLoans


@Composable
fun Home() {
    Surface(color = MaterialTheme.colorScheme.background) {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            AllLoans(loans)
        }

    }
}

@Composable
fun Favorite() {

}

@Composable
fun Profile() {

}