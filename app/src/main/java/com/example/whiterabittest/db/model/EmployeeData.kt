package com.example.whiterabittest.db.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class EmployeeData(
    @PrimaryKey(autoGenerate = false)
    val id : Int,
    val name : String,
    val username : String,
    val email : String,
    val profile_image : String,
    val phone : String,
    val website : String


)//    val company : CompanyData
//    val address : AddressData,