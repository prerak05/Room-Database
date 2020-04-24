package com.example.roomdatabase

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class User {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
    @ColumnInfo(name = "user_name")
    var userName: String = ""
    @ColumnInfo(name = "email_id")
    var email: String = ""

    constructor(userName: String, email: String) {
        this.userName = userName
        this.email = email
    }
}