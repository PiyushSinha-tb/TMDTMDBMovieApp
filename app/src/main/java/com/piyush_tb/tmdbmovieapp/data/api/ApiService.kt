package com.piyush_tb.tmdbmovieapp.data.api

import com.piyush_tb.tmdbmovieapp.data.Model.MovieInfo
import com.piyush_tb.tmdbmovieapp.data.Model.Response
import com.piyush_tb.tmdbmovieapp.data.Model.Reviews

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("3/movie/now_playing")
  suspend fun getMovieList(
        @Query("api_key") apiKey: String,
        @Query("language") lan: String,
        @Query("page") page: Int
    ):Response
    @GET("3/movie/{movie_id}")
    suspend fun getMovieInformation(
        @Path("movie_id") movie_id: String,
        @Query("api_key") apiKey: String,
        @Query("language") lan: String

    ):MovieInfo
    @GET("3/movie/{movie_id}/reviews")
    suspend fun getReview(
        @Path("movie_id") movie_id: String,
        @Query("api_key") apiKey: String,
        @Query("language") lan: String

    ): Reviews
}