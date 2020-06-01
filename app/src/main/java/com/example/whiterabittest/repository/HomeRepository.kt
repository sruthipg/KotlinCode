package com.example.whiterabittest.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.whiterabittest.db.UserDataBase
import com.example.whiterabittest.db.model.EmployeeData
import com.example.whiterabittest.network.MyApi
import com.example.whiterabittest.network.SafeApiRequest
import com.example.whiterabittest.utils.Coroutines
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


class HomeRepository(private val api: MyApi,
                     private val db: UserDataBase): SafeApiRequest() {

    private val employee = MutableLiveData<List<EmployeeData>>()

    init {
        employee.observeForever {
            saveEmployee(it)
        }
    }



    suspend fun getEmployee(): LiveData<List<EmployeeData>> {
        return withContext(Dispatchers.IO) {
            fetchEmployee()
            db.saveuserdata().getEmployee()
        }
    }

    private suspend fun fetchEmployee() {

            try {
                val response = apiRequest { api.getEmployee() }
                employee.postValue(response)
            } catch (e: Exception) {
                e.printStackTrace()
            }

    }

    private fun saveEmployee(quotes: List<EmployeeData>) {
        Coroutines.io {

            db.saveuserdata().saveAllEmployee(quotes)
        }
    }

}