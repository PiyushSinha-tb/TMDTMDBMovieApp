package com.piyush_tb.tmdbmovieapp.data.api

class ApiHelper (private val apiService: ApiService,private val key: String)
{
  suspend  fun getMovieInfo()=apiService.getMovieList(key,"en-US",1)
}