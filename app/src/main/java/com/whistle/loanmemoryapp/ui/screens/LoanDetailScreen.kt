package com.whistle.loanmemoryapp.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.whistle.loanmemoryapp.MainViewModel


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun LoanDetailScreen(
    navController: NavHostController,
    name: String?,
    mainViewModel: MainViewModel = hiltViewModel(),
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = if (name != "{name}") name!!
                    else "Новый кредит"
                    )
                },
                backgroundColor = Color.White,
                navigationIcon = {
                    IconButton(
                        onClick = { navController.navigateUp() }
                    ) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                }
            )
        },
        content = {
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                Column {
                    Icon(
                        imageVector = Icons.Filled.DateRange,
                        contentDescription = "Date"
                    )
                }
                Column(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    TextField(
                        value = mainViewModel.dateText.value,
                        onValueChange = {
                            mainViewModel.dateText.value = it
                        }
                    )
                }
            }
        }
    )
}
