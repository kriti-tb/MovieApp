package com.`fun`.movieapp.data.repository

import com.`fun`.movieapp.data.api.ApiHelper

class MainRepository(private val apiHelper: ApiHelper) {
    suspend fun getMovieList() = apiHelper.getMovieList();
    suspend fun getMovieInfo()=apiHelper.getMovieInfo()
    suspend fun getReview()=apiHelper.getReview()
}
