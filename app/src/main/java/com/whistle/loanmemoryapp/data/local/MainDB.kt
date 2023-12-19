package com.whistle.loanmemoryapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.whistle.loanmemoryapp.data.model.Loan

@Database(
    entities = [
        Loan::class
    ],
    version = 1
)
abstract class MainDB : RoomDatabase() {
    abstract val dao: Dao
}
