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
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.whistle.loanmemoryapp.R
import com.whistle.loanmemoryapp.data.model.Loan
import com.whistle.loanmemoryapp.ui.theme.LoanMemoryAppTheme


@Composable
fun LoanList(loanList: MutableState<List<Loan>>, navController: NavController) {
    LoanMemoryAppTheme {
        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(16.dp)
        ) {
            items(loanList.value) { item ->
                LoanCard(item.id, item.name, item.amountMonth, navController)
            }
        }
    }
}

@Composable
fun LoanCard(
    id: Int?,
    name: String?,
    amountMonth: String?,
    navController: NavController) {
    val checkedState = remember { mutableStateOf(false) }
    Card(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
            .wrapContentHeight()
            .clickable {
                navController.navigate("loan_detail/$id")
            },
        shape = MaterialTheme.shapes.medium,
        elevation = CardDefaults.cardElevation( defaultElevation = 5.dp ),
        colors = CardDefaults.cardColors( containerColor = MaterialTheme.colorScheme.surfaceVariant ),
    ) {
        Row(
            modifier = Modifier.padding(8.dp).fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = null,
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .border(1.5.dp, MaterialTheme.colorScheme.primary, CircleShape)
                    .padding(8.dp)
                    .align(Alignment.CenterVertically)
            )

            Spacer(modifier = Modifier.width(8.dp))

            Column(
                modifier = Modifier.weight(1f)
            ) {
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
            Column(
                modifier = Modifier.align(Alignment.CenterVertically)
            ) {
                Checkbox(
                    checked = checkedState.value,
                    onCheckedChange = {checkedState.value = it}
                )
            }
        }
    }
}

@Preview("ListPreview")
@Composable
fun LoanListPreview() {
    val sampleLoanList = remember { mutableStateOf(
        listOf(
            Loan(1, "VTB", "01.01.2022", "2000"),
            Loan(2, "Sample Loan 2", "02.02.2022", "3000"),
            Loan(3, "Sample Loan 2", "02.02.2022", "3000"),
            Loan(4, "Sample Loan 2", "02.02.2022", "3000"),
            Loan(5, "Sample Loan 2", "02.02.2022", "3000")
        )
    )}
    LoanList(loanList = sampleLoanList, navController = rememberNavController())
}
