package com.`fun`.movieapp.view.adapter

import androidx.recyclerview.widget.DiffUtil

class MovieDiffCallback : DiffUtil.ItemCallback<Any>()
 {
     override fun areItemsTheSame(oldItem: Any, newItem: Any): Boolean {
         return false

     }

     override fun areContentsTheSame(oldItem: Any, newItem: Any): Boolean {
         return false

     }
 }