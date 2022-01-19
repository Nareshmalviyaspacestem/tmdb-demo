package com.movies.tmdb.api

import com.google.gson.annotations.SerializedName
import com.movies.tmdb.model.Movie

data class MovieResponse(
    @SerializedName("page") val page: Int = 0,
    @SerializedName("results") val items: List<Movie> = emptyList()
)
