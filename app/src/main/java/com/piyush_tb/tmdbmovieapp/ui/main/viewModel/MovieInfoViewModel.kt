package com.piyush_tb.tmdbmovieapp.ui.main.viewModel

import android.util.Log
import androidx.lifecycle.*
import com.piyush_tb.tmdbmovieapp.data.Model.Result
import com.piyush_tb.tmdbmovieapp.data.Repository.MainRepository
import com.piyush_tb.tmdbmovieapp.data.api.ApiHelper
import com.piyush_tb.tmdbmovieapp.data.api.RetrofitBuilder
import com.piyush_tb.tmdbmovieapp.ui.base.ViewModelFactory
import com.piyush_tb.tmdbmovieapp.utils.Resource
import kotlinx.coroutines.Dispatchers

class MovieInfoViewModel(private val mainRepository: MainRepository) : ViewModel() {

    init {

        Log.i("GameViewModel", "GameViewModel created!")

    }


    fun getMovieInfo() = liveData(Dispatchers.IO) {
        emit(Resource.loading(data   = null))
        try {
            emit(Resource.success(data = mainRepository.getMovieInfor()))
        } catch (exception: Exception) {
            emit(Resource.error(data = null, msg = exception.message ?: "Error Occurred!"))
        }
}

}