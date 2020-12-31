package com.piyush_tb.tmdbmovieapp.data.Model

import com.google.gson.annotations.SerializedName

data class Author_details(
    @SerializedName("name") val name : String,
    @SerializedName("username") val username : String,
    @SerializedName("avatar_path") val avatar_path : String,
    @SerializedName("rating") val rating : String
)