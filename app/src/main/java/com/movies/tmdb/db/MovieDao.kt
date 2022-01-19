package com.movies.tmdb.db

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.movies.tmdb.model.Movie

@Dao
interface MovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(movies: List<Movie>)

    @Query(
        "SELECT * FROM movies"
    )
    fun getAllMovies(): PagingSource<Int, Movie>

    @Query("DELETE FROM movies")
    suspend fun clearRepos()
}
