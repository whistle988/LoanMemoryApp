package com.whistle.loanmemoryapp.ui

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.whistle.loanmemoryapp.data.local.MainDB
import com.whistle.loanmemoryapp.data.model.Loan
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(
    val dataBase: MainDB
) : ViewModel() {
    val dateText = mutableStateOf("")
    val loanList = mutableStateOf(emptyList<Loan>())

    fun getAllItems() = viewModelScope.launch {
        loanList.value = dataBase.dao.getAllItems()
    }

    fun insertItem(item: Loan) = viewModelScope.launch {
        dataBase.dao.insertItem(item)
    }

    fun deleteItem(item: Loan) = viewModelScope.launch {
        dataBase.dao.deleteItem(item)
    }

    fun getListByID(id: Int): List<Loan> {
        return loanList.value.filter { it.id == id }
    }
}
