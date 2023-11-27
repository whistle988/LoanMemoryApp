package com.whistle.loanmemoryapp.ui.loan

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.whistle.loanmemoryapp.data.model.Loan
import com.whistle.loanmemoryapp.ui.theme.LoanMemoryAppTheme

@Composable
fun AllLoans(loanList: List<Loan>) {
    LoanMemoryAppTheme {
        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(16.dp)
        ) {
            items(loanList) {loan ->
                LoanCard(loan.name, loan.amountMonth)
            }
        }
    }
}
