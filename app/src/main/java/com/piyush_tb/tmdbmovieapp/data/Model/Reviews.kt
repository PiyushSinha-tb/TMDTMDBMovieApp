package com.piyush_tb.tmdbmovieapp.data.Model

import com.google.gson.annotations.SerializedName

data class Reviews(
    @SerializedName("id") val id : Int,
    @SerializedName("page") val page : Int,
    @SerializedName("results") val results : List<ReviewResponse>
)