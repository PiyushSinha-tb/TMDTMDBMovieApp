package com.piyush_tb.tmdbmovieapp.ui.main.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

import com.piyush_tb.tmdbmovieapp.R
import com.piyush_tb.tmdbmovieapp.data.Model.Result
import com.piyush_tb.tmdbmovieapp.databinding.FragmentMovieBinding
import com.piyush_tb.tmdbmovieapp.databinding.MoviecontainerBinding
import com.squareup.picasso.Picasso
import kotlinx.coroutines.withContext
import com.piyush_tb.tmdbmovieapp.ui.main.adapter.MoviesAdapter.MovieViewHolder as MovieViewHolder1

class MoviesAdapter () :
        ListAdapter<Any,RecyclerView.ViewHolder>(MovieDiffCallback())
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        val inflater = LayoutInflater.from(parent.context)
        val binding=MoviecontainerBinding.inflate(inflater)
        return MovieViewHolder1(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as MovieViewHolder).bind(getItem(position) as Result)
    }
    override fun submitList(list: MutableList<*>?) {
        super.submitList(list?.let { ArrayList(it) })
    }
    override fun getItemViewType(position: Int): Int {
     super.getItemViewType(position)
        return R.layout.moviecontainer
    }
    class MovieViewHolder(val binding: MoviecontainerBinding):RecyclerView.ViewHolder(binding.root)
    {
        fun bind(item :Result) {
            with(binding)
            {
                nameMovie.text=item.title
                movieLan.text="lan "+item.original_language
                movieRating.text=item.popularity.toString()
               movieReleaseDate.text="Release Date "+item.release_date
                val url="http://image.tmdb.org/t/p/w300"+item.poster_path
                Log.d("TAG", "bind: "+url)
                Glide.with(binding.root.context).load(url).into(moviePoster)
            }
        }

    }

}