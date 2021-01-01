package com.piyush_tb.tmdbmovieapp.ui.main.adapter

import androidx.recyclerview.widget.DiffUtil
import com.piyush_tb.tmdbmovieapp.data.Model.Result

class MovieDiffCallback :DiffUtil.ItemCallback<Any>()
{
    override fun areItemsTheSame(oldItem: Any, newItem: Any)=(oldItem as Result).id==(newItem as Result).id

    override fun areContentsTheSame(oldItem: Any, newItem: Any): Boolean {
        return true
    }

}