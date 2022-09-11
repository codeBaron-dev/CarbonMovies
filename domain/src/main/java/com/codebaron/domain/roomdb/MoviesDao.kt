package com.codebaron.domain.roomdb

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.codebaron.domain.models.movies.Result

@Dao
interface MoviesDao {

    @Query("SELECT * FROM movies_table")
    fun getAllLocalMovies(): List<Result>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertMovies(movie: List<Result>?)

    @Query("DELETE FROM movies_table")
    fun deleteAll()
}