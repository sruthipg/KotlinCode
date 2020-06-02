package com.example.whiterabittest.db.model

import AddressData
import CompanyData
import androidx.room.*

@Entity
data class EmployeeData(

    @PrimaryKey val id : Int,
    val name : String?,
    val username : String?,
    val email : String?,
    val profile_image : String?,
    val phone : String?,
    val website : String?


//    val company : CompanyData,
//    val address : AddressData
)