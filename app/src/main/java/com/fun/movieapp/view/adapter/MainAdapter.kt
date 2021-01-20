package com.`fun`.movieapp.view.adapter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.`fun`.movieapp.R
import com.`fun`.movieapp.data.model.Result
import com.`fun`.movieapp.view.MovieListViewHolder


class MainAdapter(): ListAdapter<Any, RecyclerView.ViewHolder>(MovieDiffCallback())
{

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        var viewHolder : RecyclerView.ViewHolder? = null
        val inflater = LayoutInflater.from(parent.context)
        when(viewType){
            R.layout.item_layout -> viewHolder = MovieListViewHolder.create(inflater , parent)
        }
        return  viewHolder!!
    }
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as MovieListViewHolder).bind(getItem(position) as Result)
        val bundle= Bundle()
        bundle.putInt("movie_id",(getItem(position) as Result).id)


    }
    override fun getItemCount(): Int {
        return super.getItemCount()
    }
    override fun submitList(list: MutableList<*>?) {
        super.submitList(list?.let { ArrayList(it) })
    }
    override fun getItemViewType(position: Int): Int {
        super.getItemViewType(position)
        return R.layout.main_fragment
    }


    }






