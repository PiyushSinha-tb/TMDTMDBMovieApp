package com.piyush_tb.tmdbmovieapp.ui.main.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.piyush_tb.tmdbmovieapp.R
import com.piyush_tb.tmdbmovieapp.databinding.FragmentMovieBinding
import com.piyush_tb.tmdbmovieapp.databinding.FragmentMovieInfoBinding


class MovieInfoFragment : Fragment() {
    private lateinit var binding: FragmentMovieInfoBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_movie_info, container, false
        )
        val id=MovieInfoFragmentArgs.fromBundle(requireArguments()).movieId
        binding.check.text=id.toString()
        return binding.root
    }


}