package com.piyush_tb.tmdbmovieapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.piyush_tb.tmdbmovieapp.data.Model.Response
import com.piyush_tb.tmdbmovieapp.data.api.ApiHelper
import com.piyush_tb.tmdbmovieapp.data.api.RetrofitBuilder
import com.piyush_tb.tmdbmovieapp.ui.base.ViewModelFactory
import com.piyush_tb.tmdbmovieapp.ui.main.viewModel.MovieListViewModel
import com.piyush_tb.tmdbmovieapp.utils.Status

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: MovieListViewModel
   private lateinit var tv:TextView;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContentView(R.layout.activity_main)
        tv=findViewById(R.id.text1)
        setupViewModel()
        setupObservers()
    }

     fun setupViewModel() {
        viewModel=ViewModelProviders.of(this,ViewModelFactory(ApiHelper(RetrofitBuilder.apiService,"4f754b166590c0ebf7ec75b973f4eaeb"))).get(MovieListViewModel::class.java)
    }

    private fun setupObservers() {
        viewModel.getMovieList().observe(this, Observer { it?.let {
            resource ->
            when(resource.status)
            {
                Status.SUCCESS->{
                    resource.data?.let { response -> retrieveList(response) }
                }
                Status.ERROR->{
                    Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                }
                Status.LOADING->{

                }
            }
        } })
    }
    private fun retrieveList(response: Response) {
        Log.d("TAG", "retrieveList: "+response.result.get(0).id)
        tv.setText(response.result.get(0).title)

    }
}