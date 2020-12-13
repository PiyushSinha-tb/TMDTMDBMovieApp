package com.piyush_tb.tmdbmovieapp.ui.main.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.LinearLayout
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.*
import com.piyush_tb.tmdbmovieapp.R
import com.piyush_tb.tmdbmovieapp.data.Model.Response
import com.piyush_tb.tmdbmovieapp.data.Model.Result
import com.piyush_tb.tmdbmovieapp.data.api.ApiHelper
import com.piyush_tb.tmdbmovieapp.data.api.RetrofitBuilder
import com.piyush_tb.tmdbmovieapp.databinding.FragmentMovieBinding
import com.piyush_tb.tmdbmovieapp.ui.base.ViewModelFactory
import com.piyush_tb.tmdbmovieapp.ui.main.adapter.MoviesAdapter
import com.piyush_tb.tmdbmovieapp.ui.main.viewModel.MovieFragmentViewModel
import com.piyush_tb.tmdbmovieapp.utils.Status

class MovieFragment : Fragment() {
    private lateinit var viewModel: MovieFragmentViewModel
    private lateinit var binding: FragmentMovieBinding
    private lateinit var adapter: MoviesAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        setupViewModel()
        setupObservers()
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_movie, container, false
        )
        return binding.root
    }

    private fun setupViewModel() {
        viewModel = ViewModelProviders.of(
            this,
            ViewModelFactory(
                ApiHelper(
                    RetrofitBuilder.apiService,
                    "4f754b166590c0ebf7ec75b973f4eaeb"
                )
            )
        ).get(MovieFragmentViewModel::class.java)
    }

    private fun setupObservers() {
        viewModel.getMovieList().observe(viewLifecycleOwner, Observer {
            it?.let { resource ->
                when (resource.status) {
                    Status.SUCCESS -> {
                        resource.data?.let { response -> initRv(response)}
                    }
                    Status.ERROR -> {
                        Toast.makeText(activity, it.message, Toast.LENGTH_LONG).show()
                    }
                    Status.LOADING -> {

                    }
                }
            }
        })
    }

    private fun initRv(response: Response) {
        adapter= MoviesAdapter()
        adapter.submitList(response.result as MutableList<*>)


        binding.movieslist.layoutManager=LinearLayoutManager(activity,LinearLayoutManager.VERTICAL,false)

        binding.movieslist.adapter=adapter




    }
}