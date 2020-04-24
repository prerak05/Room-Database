package com.example.roomdatabase

import android.content.Context
import androidx.room.*
import androidx.sqlite.db.SupportSQLiteOpenHelper

@Database(entities = arrayOf(User::class), version = 1)
abstract class AppDB : RoomDatabase() {
    abstract fun userDao(): UserDao

    companion object {
        private var INSTANCE: AppDB? = null
        fun getInstance(context: Context): AppDB {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(
                    context,
                    AppDB::class.java,
                    "user.db"
                ).allowMainThreadQueries()
                    .build()
            }
            return INSTANCE as AppDB
        }
    }
}