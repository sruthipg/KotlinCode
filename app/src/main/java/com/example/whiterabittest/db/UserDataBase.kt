package com.example.whiterabittest.db

import android.content.Context

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.whiterabittest.db.model.EmployeeData


@Database(
    entities = [EmployeeData::class],
    version = 1
)
abstract class UserDataBase : RoomDatabase() {

    abstract fun saveuserdata(): EmployeeDao

    companion object {

        @Volatile
        private var instance: UserDataBase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: buildDatabase(context).also {
                instance = it
            }
        }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                UserDataBase::class.java,
                "MyAppDatabase.db"
            ).build()
    }
}