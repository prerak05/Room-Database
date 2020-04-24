package com.example.roomdatabase

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_user.view.*

class UserAdapter(var list: ArrayList<User>) : RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    fun updateData(data: List<User>) {
        list.clear()
        list.addAll(data)
//        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false)
    )

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvName = view.tvUserName
        val tvEmail = view.tvEmail

        fun bind(user: User) {
            tvName.text = user.userName
            tvEmail.text = user.email
        }
    }
}