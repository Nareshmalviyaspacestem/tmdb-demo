package com.movies.tmdb.data

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.movies.tmdb.api.MovieService
import com.movies.tmdb.db.MovieDatabase
import com.movies.tmdb.model.Movie
import kotlinx.coroutines.flow.Flow

class MovieRepository(
    private val service: MovieService,
    private val database: MovieDatabase
) {
    fun getSearchResultStream(query: String): Flow<PagingData<Movie>> {


        val pagingSourceFactory = { database.movisDao().getAllMovies() }

        @OptIn(ExperimentalPagingApi::class)
        return Pager(
            config = PagingConfig(pageSize = NETWORK_PAGE_SIZE, enablePlaceholders = false),
            remoteMediator = GithubRemoteMediator(
                service,
                database
            ),
            pagingSourceFactory = pagingSourceFactory
        ).flow
    }

    companion object {
        const val NETWORK_PAGE_SIZE = 20
    }
}
