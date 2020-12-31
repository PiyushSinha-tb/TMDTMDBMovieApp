package com.piyush_tb.tmdbmovieapp.ui.main.adapter


import android.text.Html
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.piyush_tb.tmdbmovieapp.R
import com.piyush_tb.tmdbmovieapp.data.Model.ReviewResponse
import com.piyush_tb.tmdbmovieapp.databinding.ReviewlayoutBinding
import java.text.SimpleDateFormat
import java.util.*

class ReviewAdapter () :
    ListAdapter<Any, RecyclerView.ViewHolder>(MovieDiffCallback())
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding= ReviewlayoutBinding.inflate(inflater,parent,false)
        return ReviewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ReviewHolder).bind(getItem(position) as ReviewResponse)
    }
    class ReviewHolder(val binding: ReviewlayoutBinding):RecyclerView.ViewHolder(binding.root)
    {
        fun bind(item : ReviewResponse) {
            with(binding)
            {
                movieReview.text=Html.fromHtml(item.content)
                val url="http://image.tmdb.org/t/p/w300"+item.author_details.avatar_path
                val timeFormar=SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSX")
                timeFormar.setTimeZone(TimeZone.getTimeZone("UTC"))
                val date: Date = timeFormar.parse(item.created_at)
                val outputFormat =
                    SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)
                reviewerDate.text=outputFormat.format(date)
                Glide.with(binding.root.context).load(url)
                    .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC).error(R.drawable.ic_user).into(reviewavatar)
                if(item.author_details.rating!=null)
                {
                    movieReviewRating.text=item.author_details.rating+"/10"
                }
                else{
                    movieReviewRating.text="Not yet rated"
                }
                if(item.author_details.name!=null&&item.author_details.name.length>0 )
                {
                    Log.d("TAG", "bind: "+item.author_details.name)
                    binding.reviewername.text=item.author_details.name
                }
                else
                {
                    Log.d("TAG", "bind: "+item.author_details.username)
                    binding.reviewername.text=item.author_details.username
                }
            }

        }

    }

}