package com.whistle.loanmemoryapp.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.whistle.loanmemoryapp.data.model.Loan


@Dao
interface Dao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertItem(loan: Loan)

    @Delete
    suspend fun deleteItem(loan: Loan)

    @Query("SELECT * FROM loan_table")
    fun getAllItems(): List<Loan>
}
