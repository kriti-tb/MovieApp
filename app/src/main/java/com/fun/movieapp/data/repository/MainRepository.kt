package com.`fun`.movieapp.data.repository

import com.`fun`.movieapp.data.api.ApiHelper

class MainRepository(private val apiHelper: ApiHelper) {
    suspend fun getMovieList1() = apiHelper.getMovieList()
    suspend fun getMovieInfo1()=apiHelper.getMovieInfo()
    //suspend fun getReview()=apiHelper.getReview()
}
