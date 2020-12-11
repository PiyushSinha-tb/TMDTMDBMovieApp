package com.piyush_tb.tmdbmovieapp.ui.main.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.piyush_tb.tmdbmovieapp.data.Repository.MainRepository
import com.piyush_tb.tmdbmovieapp.utils.Resource
import kotlinx.coroutines.Dispatchers

class MovieListViewModel(private val mainRepository: MainRepository) : ViewModel() {

    fun getMovieList() = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = mainRepository.getMovieList()))
        } catch (exception: Exception) {
            emit(Resource.error(data = null, msg = exception.message ?: "Error Occurred!"))
        }
    }
}