package com.`fun`.movieapp.data.api


class ApiHelper(private val apiService: ApiService, private val key: String, private val movieId:String) {

    suspend fun getMovieList() = apiService.getMovieList(key, "en-US", 1)
    suspend fun getMovieInfo()= apiService.getMovieInfo(movieId, key, "en-US")
    suspend fun getReview()=apiService.getReview(movieId, key, "en-US")


}