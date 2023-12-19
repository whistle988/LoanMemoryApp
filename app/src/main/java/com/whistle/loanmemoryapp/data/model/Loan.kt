package com.whistle.loanmemoryapp.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity (tableName = "loan_table")
data class Loan(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val name: String?,
    val date: String?,
    val amountMonth: String?
)
