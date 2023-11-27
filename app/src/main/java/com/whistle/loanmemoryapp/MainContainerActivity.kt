package com.whistle.loanmemoryapp

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.whistle.loanmemoryapp.data.model.loans
import com.whistle.loanmemoryapp.ui.bottom.BottomBar
import com.whistle.loanmemoryapp.ui.bottom.NavigationGraph
import com.whistle.loanmemoryapp.ui.loan.AllLoans
import com.whistle.loanmemoryapp.ui.theme.BottomBarExampleTheme
import com.whistle.loanmemoryapp.ui.theme.LoanMemoryAppTheme

class MainContainerActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoanMemoryAppTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    AllLoans(loans)
                }
            }
            BottomBarExampleTheme {

                val navController: NavHostController = rememberNavController()
                val bottomBarHeight = 56.dp
                val bottomBarOffsetHeightPx = remember { mutableStateOf(0f) }

                var buttonsVisible = remember { mutableStateOf(true) }

                Scaffold(
                    bottomBar = {
                        BottomBar(
                            navController = navController,
                            state = buttonsVisible,
                            modifier = Modifier
                        )
                    }) { paddingValues ->
                    Box(
                        modifier = Modifier.padding(paddingValues)
                    ) {
                        NavigationGraph(navController = navController)
                    }
                }
            }
        }
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO, showBackground = true, name = "Light Mode")
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true, name = "Dark Mode")
@Composable
fun LoansPreview() {
    LoanMemoryAppTheme {
        AllLoans(loans)
    }
}
