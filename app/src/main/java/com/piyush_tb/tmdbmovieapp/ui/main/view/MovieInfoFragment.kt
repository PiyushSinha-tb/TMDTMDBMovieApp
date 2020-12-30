package com.piyush_tb.tmdbmovieapp.ui.main.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.piyush_tb.tmdbmovieapp.R
import com.piyush_tb.tmdbmovieapp.data.Model.MovieInfo
import com.piyush_tb.tmdbmovieapp.data.api.ApiHelper
import com.piyush_tb.tmdbmovieapp.data.api.RetrofitBuilder
import com.piyush_tb.tmdbmovieapp.databinding.FragmentMovieBinding
import com.piyush_tb.tmdbmovieapp.databinding.FragmentMovieInfoBinding
import com.piyush_tb.tmdbmovieapp.ui.base.MovieInfoViewModelFactory
import com.piyush_tb.tmdbmovieapp.ui.main.viewModel.MovieInfoViewModel
import com.piyush_tb.tmdbmovieapp.utils.Status
import com.squareup.picasso.Downloader
import jp.wasabeef.glide.transformations.BlurTransformation


class MovieInfoFragment : Fragment() {
    private lateinit var viewModel:MovieInfoViewModel
    private lateinit var binding: FragmentMovieInfoBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        setupViewModel()
        setupObservers()
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_movie_info, container, false
        )
        val id=MovieInfoFragmentArgs.fromBundle(requireArguments()).movieId

        return binding.root
    }
    private fun setupViewModel() {
        viewModel = ViewModelProviders.of(
            this,
            MovieInfoViewModelFactory(
                ApiHelper(
                    RetrofitBuilder.apiService,
                    "4f754b166590c0ebf7ec75b973f4eaeb",
                    MovieInfoFragmentArgs.fromBundle(requireArguments()).movieId.toString()
                )
            )
        ).get(MovieInfoViewModel::class.java)
    }
    private fun setupObservers() {
        Log.d("TAG", "setupObservers: f");
        viewModel.getMovieInfo().observe(viewLifecycleOwner, Observer {
            it?.let { resource ->
                when (resource.status) {
                    Status.SUCCESS -> {

                        resource.data?.let { response ->
                            Log.d("TAG", "setupObservers: succes"+response.original_title);
                            bindView(response)


                        }
                    }
                    Status.ERROR -> {
                        Log.d("TAG", "setupObservers: "+it.message)
                        Toast.makeText(activity, it.message, Toast.LENGTH_LONG).show()
                    }
                    Status.LOADING -> {

                    }
                }
            }
        })
    }
private fun bindView(response: MovieInfo)
{

    val url="http://image.tmdb.org/t/p/w400"+response.poster_path;
    Glide.with(binding.root.context).
    load(url)
        .apply(RequestOptions.bitmapTransform(BlurTransformation(25, 3)))
        .into(binding.blurimageView)
    Glide.with(binding.root.context).
    load(url)
        .into(binding.moviePoster)
}

}