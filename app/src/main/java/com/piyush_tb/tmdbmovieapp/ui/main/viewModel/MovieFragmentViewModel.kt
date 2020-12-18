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

class MovieFragmentViewModel(private val mainRepository: MainRepository) : ViewModel() {
    private val _movieList = MutableLiveData<List<Result>>()
    val movie: LiveData<List<Result>>
        get() = _movieList
    init {

        Log.i("GameViewModel", "GameViewModel created!")

    }


    fun getMovieList() = liveData(Dispatchers.IO) {
        emit(Resource.loading(data   = null))
        try {
            emit(Resource.success(data = mainRepository.getMovieList()))
        } catch (exception: Exception) {
            emit(Resource.error(data = null, msg = exception.message ?: "Error Occurred!"))
        }
}

}