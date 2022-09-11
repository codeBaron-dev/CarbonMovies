package com.codebaron.domain.roomdb

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.codebaron.domain.models.movies.Result

@Database(entities = [Result::class], version = 1)
abstract class MovieDatabase: RoomDatabase() {
    abstract fun MoviesDao(): MoviesDao

    companion object {
        @Volatile
        private var instance: MovieDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: buildDatabase(context).also { instance = it }
        }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(context, MovieDatabase::class.java, "movie_db")
                .allowMainThreadQueries()
                .build()
    }
}