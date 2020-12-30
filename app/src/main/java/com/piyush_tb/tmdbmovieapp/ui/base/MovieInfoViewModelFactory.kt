package com.piyush_tb.tmdbmovieapp.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.piyush_tb.tmdbmovieapp.data.Repository.MainRepository
import com.piyush_tb.tmdbmovieapp.data.api.ApiHelper
import com.piyush_tb.tmdbmovieapp.ui.main.viewModel.MovieFragmentViewModel
import com.piyush_tb.tmdbmovieapp.ui.main.viewModel.MovieInfoViewModel


class MovieInfoViewModelFactory(private val apiHelper: ApiHelper):ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MovieInfoViewModel::class.java))
        {
            return (MovieInfoViewModel(MainRepository(apiHelper))) as T
        }
        throw IllegalArgumentException("Unknown Class name")
    }

}