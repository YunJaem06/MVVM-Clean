package com.example.mvvmcleanarchitecture.data
import com.google.gson.annotations.SerializedName

data class MovieList(
    @SerializedName("results")
    val results: List<Movie>
)