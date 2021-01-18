package com.`fun`.movieapp.view.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class MainAdapter() : RecyclerView.Adapter<MainAdapter.DataViewHolder>() {



        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder =
                DataViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false))


        override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
            holder.bind(users[position])
        }

        fun addUsers(users: List<User>) {
            this.users.apply {
                clear()
                addAll(users)
            }

        }
    }
}