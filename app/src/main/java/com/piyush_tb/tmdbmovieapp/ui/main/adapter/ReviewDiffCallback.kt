package com.piyush_tb.tmdbmovieapp.ui.main.adapter

import androidx.recyclerview.widget.DiffUtil
import com.piyush_tb.tmdbmovieapp.data.Model.Result
import com.piyush_tb.tmdbmovieapp.data.Model.ReviewResponse

class ReviewDiffCallback :DiffUtil.ItemCallback<Any>()
{
    override fun areItemsTheSame(oldItem: Any, newItem: Any)=(oldItem as ReviewResponse).id==(newItem as ReviewResponse).id

    override fun areContentsTheSame(oldItem: Any, newItem: Any)=(oldItem as ReviewResponse).content==(newItem as ReviewResponse).content

}