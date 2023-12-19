package com.whistle.loanmemoryapp.di

import android.app.Application
import androidx.room.Room
import com.whistle.loanmemoryapp.data.local.MainDB
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object MainModule {

    @Provides
    @Singleton
    fun provideMainDB(app: Application): MainDB {
        return Room.databaseBuilder(
            app,
            MainDB::class.java,
            "loan.db"
        ).allowMainThreadQueries().createFromAsset("db/loan.db").build()
    }
}
