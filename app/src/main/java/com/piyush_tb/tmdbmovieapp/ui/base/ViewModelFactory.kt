package com.piyush_tb.tmdbmovieapp.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.piyush_tb.tmdbmovieapp.data.Repository.MainRepository
import com.piyush_tb.tmdbmovieapp.data.api.ApiHelper
import com.piyush_tb.tmdbmovieapp.ui.main.viewModel.MovieFragmentViewModel


class ViewModelFactory(private val apiHelper: ApiHelper):ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MovieFragmentViewModel::class.java))
        {
            return (MovieFragmentViewModel(MainRepository(apiHelper))) as T
        }
        throw IllegalArgumentException("Unknown Class name")
    }

}