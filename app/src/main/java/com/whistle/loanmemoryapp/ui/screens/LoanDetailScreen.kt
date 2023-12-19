package com.whistle.loanmemoryapp.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.whistle.loanmemoryapp.MainViewModel
import com.whistle.loanmemoryapp.R


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
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp),
                shape = RoundedCornerShape(10.dp)
            ) {
                Column {
                    Row(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column(
                            modifier = Modifier.padding(15.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Filled.DateRange,
                                contentDescription = "Date",
                                modifier = Modifier
                                    .height(40.dp)
                                    .width(40.dp)
                            )
                        }
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 10.dp)
                        ) {
                            Text(
                                text = "Первый платеж",
                                modifier = Modifier
                                    .fillMaxWidth(),
                                textAlign = TextAlign.Start
                            )
                            BasicTextField(
                                value = mainViewModel.dateText.value,
                                onValueChange = {
                                    mainViewModel.dateText.value = it
                                },
                                Modifier
                                    .fillMaxWidth()
                                    .padding(top = 10.dp)
                            )
                        }
                    }
                    Row(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column(
                            modifier = Modifier.padding(15.dp)
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_money),
                                contentDescription = "Date",
                                modifier = Modifier
                                    .height(40.dp)
                                    .width(40.dp)
                            )
                        }
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 10.dp)
                        ) {
                            Text(
                                text = "Сумма кредита",
                                modifier = Modifier
                                    .fillMaxWidth(),
                                textAlign = TextAlign.Start
                            )
                            BasicTextField(
                                value = mainViewModel.dateText.value,
                                onValueChange = {
                                    mainViewModel.dateText.value = it
                                },
                                Modifier
                                    .fillMaxWidth()
                                    .padding(top = 10.dp)
                            )
                        }
                    }
                    Row(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column(
                            modifier = Modifier.padding(15.dp)
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_timelapse),
                                contentDescription = "Date",
                                modifier = Modifier
                                    .height(40.dp)
                                    .width(40.dp)
                            )
                        }
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 10.dp)
                        ) {
                            Text(
                                text = "Срок кредита",
                                modifier = Modifier
                                    .fillMaxWidth(),
                                textAlign = TextAlign.Start
                            )
                            BasicTextField(
                                value = mainViewModel.dateText.value,
                                onValueChange = {
                                    mainViewModel.dateText.value = it
                                },
                                Modifier
                                    .fillMaxWidth()
                                    .padding(top = 10.dp)
                            )
                        }
                    }
                    Row(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column(
                            modifier = Modifier.padding(15.dp)
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_bar_chart),
                                contentDescription = "Date",
                                modifier = Modifier
                                    .height(40.dp)
                                    .width(40.dp)
                            )
                        }
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 10.dp)
                        ) {
                            Text(
                                text = "Ставка, %",
                                modifier = Modifier
                                    .fillMaxWidth(),
                                textAlign = TextAlign.Start
                            )
                            BasicTextField(
                                value = mainViewModel.dateText.value,
                                onValueChange = {
                                    mainViewModel.dateText.value = it
                                },
                                Modifier
                                    .fillMaxWidth()
                                    .padding(top = 10.dp)
                            )
                        }
                    }
                    Row(
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        modifier = Modifier.fillMaxWidth().padding(8.dp)
                    ) {
                        Button(
                            onClick = { /*TODO*/ },
                            content = {
                                Text(text = "Расчитать")
                            },
                            modifier = Modifier.weight(1f).padding(5.dp)
                        )
                        Button(
                            onClick = { /*TODO*/ },
                            content = {
                                Text(text = "График")
                            },
                            modifier = Modifier.weight(1f).padding(5.dp)
                        )
                    }

                }
            }
        }
    )
}
