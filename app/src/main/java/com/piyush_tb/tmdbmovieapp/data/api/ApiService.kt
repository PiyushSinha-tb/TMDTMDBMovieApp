package com.piyush_tb.tmdbmovieapp.data.api

import com.piyush_tb.tmdbmovieapp.data.Model.MovieInfo
import com.piyush_tb.tmdbmovieapp.data.Model.Response
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
}