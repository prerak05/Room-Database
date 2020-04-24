package com.example.roomdatabase

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDao {

    @Insert
    fun addUser(user: User)

    @Query("SELECT * FROM user")
    fun getAllUser(): List<User>
}