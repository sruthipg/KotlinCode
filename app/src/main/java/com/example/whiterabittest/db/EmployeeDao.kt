package com.example.whiterabittest.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.whiterabittest.db.model.EmployeeData


@Dao
interface EmployeeDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveAllEmployee(quotes : List<EmployeeData>)

    @Query("SELECT * FROM EmployeeData")
    fun getEmployee() : LiveData<List<EmployeeData>>

}