package com.piyush_tb.tmdbmovieapp.ui.main.adapter

import androidx.recyclerview.widget.DiffUtil

class MovieDiffCallback :DiffUtil.ItemCallback<Any>()
{
    override fun areItemsTheSame(oldItem: Any, newItem: Any): Boolean {
        return true
    }

    override fun areContentsTheSame(oldItem: Any, newItem: Any): Boolean {
        return true
    }

}