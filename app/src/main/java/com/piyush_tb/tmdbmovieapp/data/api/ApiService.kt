package com.piyush_tb.tmdbmovieapp.data.api

import com.piyush_tb.tmdbmovieapp.data.Model.Response
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("3/movie/now_playing")
    fun getMovieList(
        @Query("api_key") apiKey: String,
        @Query("language") lan: String,
        @Query("page") page: Int
    ):Call<Response>
}