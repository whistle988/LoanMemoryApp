package com.whistle.loanmemoryapp

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.whistle.loanmemoryapp.data.loans
import com.whistle.loanmemoryapp.ui.AllLoans
import com.whistle.loanmemoryapp.ui.theme.LoanMemoryAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoanMemoryAppTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    AllLoans(loans)
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
