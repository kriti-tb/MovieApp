package com.`fun`.movieapp.data.api

import com.`fun`.movieapp.data.model.MovieInfo
import com.`fun`.movieapp.data.model.Review
import com.`fun`.movieapp.data.model.nowPlaying
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService{

    @GET("movie/now_playing")
    suspend fun getMovieList(
            @Query("api_key") apiKey: String,
            @Query("language") lan: String,
            @Query("page") page: Int
    ): nowPlaying
    @GET("movie/{movie_id}")
    suspend fun getMovieInfo(
            @Path("movie_id") movie_id: String,
            @Query("api_key") apiKey: String,
            @Query("language") lan: String

    ): MovieInfo
    @GET("movie/{movie_id}/reviews")
    suspend fun getReview(
            @Path("movie_id") movie_id: String,
            @Query("api_key") apiKey: String,
            @Query("language") lan: String

    ): Review
}
