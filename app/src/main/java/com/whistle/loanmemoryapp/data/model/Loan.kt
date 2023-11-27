package com.whistle.loanmemoryapp.data.model

data class Loan(
    val name: String?,
    val amountMonth: Double?
)

val loans = listOf(
    Loan(
        "ATB",
        5462.2
    ),
    Loan(
        "VTB",
        10546.0
    )
)
