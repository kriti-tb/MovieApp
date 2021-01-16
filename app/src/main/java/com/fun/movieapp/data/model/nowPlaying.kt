package com.`fun`.movieapp.data.model

import com.movieapp.data.model.Dates

data class nowPlaying(
        val dates: Dates,
        val page: Int,
        val results: List<Result>,
        val total_pages: Int,
        val total_results: Int
)