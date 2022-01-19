package com.movies.tmdb.model


sealed class RepoResult {
    data class Success(val data: List<Movie>) : RepoResult()
    data class Error(val error: Exception) : RepoResult()
}
