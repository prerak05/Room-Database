package com.example.roomdatabase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var userList: List<User>
    private var userAdapter = UserAdapter(arrayListOf())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val db = AppDB.getInstance(this)
        userList = db.userDao().getAllUser()
        initRecyclerView(userList)

        btnAdd.setOnClickListener {
            val userName = etUserName.text.toString().trim()
            val email = etEmail.text.toString().trim()
            if (userName.isEmpty()) {
                Toast.makeText(this, "Enter user name", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            } else if (email.isEmpty()) {
                Toast.makeText(this, "Enter email", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            } else {
                db.userDao().addUser(User(userName, email))
                initRecyclerView(db.userDao().getAllUser())
                clearText()
            }
        }
    }

    private fun clearText() {
        etEmail.text = null
        etUserName.text = null
        etEmail.clearFocus()
    }

    private fun initRecyclerView(userList: List<User>) {
        userAdapter.updateData(userList)
        rvUser.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = userAdapter
        }
        userAdapter.notifyDataSetChanged()
    }
}
