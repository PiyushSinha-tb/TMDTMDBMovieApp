package com.piyush_tb.tmdbmovieapp.data.api

class ApiHelper (private val apiService: ApiService,private val key: String,private val movie_id:String ="-1")
{
  suspend  fun getMovieInfo()=apiService.getMovieList(key,"en-US",1)
  suspend fun  getSingleMovieInfo()=apiService.getMovieInformation(movie_id,key,"en-US")
}