package com.whistle.loanmemoryapp.ui.loan

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.whistle.loanmemoryapp.R
import com.whistle.loanmemoryapp.data.model.Loan
import com.whistle.loanmemoryapp.ui.theme.LoanMemoryAppTheme

@Composable
fun LoanList(loanList: List<Loan>, navController: NavController) {
    LoanMemoryAppTheme {
        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(16.dp)
        ) {
            items(loanList) {loan ->
                LoanCard(loan.name, loan.amountMonth, navController)
            }
        }
    }
}

@Composable
fun LoanCard(name: String?, amountMonth: Double?, navController: NavController) {
    Card(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
            .wrapContentHeight()
            .clickable {
                navController.navigate("loan_detail")
            },
        shape = MaterialTheme.shapes.medium,
        elevation = CardDefaults.cardElevation( defaultElevation = 5.dp ),
        colors = CardDefaults.cardColors( containerColor = MaterialTheme.colorScheme.surfaceVariant )
    ) {
        Row(Modifier.padding(all = 8.dp)) {
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = null,
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .border(1.5.dp, MaterialTheme.colorScheme.primary, CircleShape)
            )

            Spacer(modifier = Modifier.width(8.dp))

            Column {
                Text(
                    text = name!!,
                    color = MaterialTheme.colorScheme.secondary,
                    style = MaterialTheme.typography.titleSmall
                )

                Spacer(modifier = Modifier.height(4.dp))

                Surface(shape = MaterialTheme.shapes.medium, shadowElevation = 1.dp) {
                    Text(
                        text = amountMonth.toString(),
                        modifier = Modifier.padding(all = 4.dp),
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }
        }
    }
}
