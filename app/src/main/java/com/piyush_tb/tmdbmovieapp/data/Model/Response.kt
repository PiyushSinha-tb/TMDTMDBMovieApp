package com.piyush_tb.tmdbmovieapp.data.Model

import com.google.gson.annotations.SerializedName

data class Response(
    @SerializedName("dates")
    val dates: Dates,
    @SerializedName("page")
    val page: Int =0,
    @SerializedName("results")
    val result: List<Result>
)

