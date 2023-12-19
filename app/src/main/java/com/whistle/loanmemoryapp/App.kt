package com.whistle.loanmemoryapp

import android.app.Application
import com.whistle.loanmemoryapp.data.local.MainDB
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App : Application() {
    //val database by lazy { MainDB.createDataBase( this) }
}