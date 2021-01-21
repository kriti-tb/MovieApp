package com.`fun`.movieapp.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.`fun`.movieapp.R
import com.`fun`.movieapp.data.model.Result
import com.`fun`.movieapp.databinding.ItemLayoutBinding

import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import kotlinx.android.synthetic.main.item_layout.view.*

class MovieListViewHolder(binding: ItemLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
    companion object{
        fun create(inflater: LayoutInflater,
                   viewGroup: ViewGroup) : MovieListViewHolder {
            val binding = DataBindingUtil.inflate<ItemLayoutBinding>(inflater, R.layout.item_layout , viewGroup ,false)
            return MovieListViewHolder(binding)
        }
    }

    fun bind(movieListResponse: Result){
        itemView.movie_lan.text= movieListResponse.original_language
        itemView.name_movie.text = movieListResponse.original_title
        itemView.movie_rating.text=movieListResponse.popularity.toString()
        itemView.movie_release_date.text= movieListResponse.release_date
        Glide.with(itemView)
                .load("https://image.tmdb.org/t/p/w342${movieListResponse.backdrop_path}")
                .transform(CenterCrop())
                .into(itemView.movie_poster)
    }

}