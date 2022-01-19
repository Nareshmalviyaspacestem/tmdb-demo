package com.movies.tmdb.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "movies")
data class Movie(
    @PrimaryKey @field:SerializedName("id") val id: Long,
    @field:SerializedName("original_title") val original_title: String,
    @field:SerializedName("overview") val overview: String,
    @field:SerializedName("poster_path") val poster_path: String?,
    @field:SerializedName("backdrop_path") val backdrop_path: String,
    @field:SerializedName("vote_count") val vote_count: Int,
    @field:SerializedName("original_language") val original_language: String?
)
