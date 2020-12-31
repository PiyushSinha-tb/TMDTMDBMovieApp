package com.piyush_tb.tmdbmovieapp.data.Model

import com.google.gson.annotations.SerializedName

data class ReviewResponse(
    @SerializedName("author") val author : String,
    @SerializedName("author_details") val author_details : Author_details,
    @SerializedName("content") val content : String,
    @SerializedName("created_at") val created_at : String,
    @SerializedName("id") val id : String,
    @SerializedName("updated_at") val updated_at : String,
    @SerializedName("url") val url : String
)