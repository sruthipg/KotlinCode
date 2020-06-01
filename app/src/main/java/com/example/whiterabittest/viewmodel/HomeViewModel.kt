package com.example.whiterabittest.viewmodel

import androidx.lifecycle.ViewModel
import com.example.whiterabittest.repository.HomeRepository
import com.example.whiterabittest.utils.lazyDeferred

class HomeViewModel(private val repository : HomeRepository) : ViewModel() {

//    fun getUserlist() = repository.getUserlist()
    suspend fun getUserlist() = repository.getEmployee()

    val userlist by lazyDeferred {
        repository.getEmployee()
    }
}