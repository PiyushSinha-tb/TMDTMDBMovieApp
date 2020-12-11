package com.piyush_tb.tmdbmovieapp.data.Repository

import com.piyush_tb.tmdbmovieapp.data.api.ApiHelper

class MainRepository(private val apiHelper: ApiHelper) {

   suspend fun getMovieList() = apiHelper.getMovieInfo();
}