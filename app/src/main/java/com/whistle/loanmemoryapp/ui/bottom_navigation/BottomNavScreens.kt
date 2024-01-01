package com.whistle.loanmemoryapp.ui.bottom_navigation

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.whistle.loanmemoryapp.data.model.Loan
import com.whistle.loanmemoryapp.ui.loan.LoanList
import com.whistle.loanmemoryapp.ui.theme.LoanMemoryAppTheme


@Composable
fun Home(
    navController: NavController,
    loanList: MutableState<List<Loan>>
         ) {
    Surface(color = MaterialTheme.colorScheme.background) {
        LoanList(loanList, navController)
    }
}

@Composable
fun Favorite() {

}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Settings(navController: NavHostController) {
    LoanMemoryAppTheme {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text(text = "Настройки")
                    },
                    backgroundColor = Color.White
                )
            },
            floatingActionButton = {
                FloatingActionButton(onClick = {  }) {
                    Icon(Icons.Default.Add, contentDescription = "Add")
                }
            }
        ) { innerPadding ->
            Column(
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxWidth()
                    .padding(5.dp),
            ) {
                Text(
                    modifier = Modifier.padding(8.dp),
                    text =
                    """
                    This is an example of a scaffold. It uses the Scaffold composable's parameters to create a screen with a simple top app bar, bottom app bar, and floating action button.

                    It also contains some basic inner content, such as this text.

                    You have pressed the floating action button presses times.
                """.trimIndent(),
                )
            }
        }
    }
}
