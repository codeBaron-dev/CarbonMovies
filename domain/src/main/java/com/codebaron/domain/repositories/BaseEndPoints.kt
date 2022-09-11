package com.codebaron.domain.repositories

import com.codebaron.core.MOVIE_DETAILS
import com.codebaron.core.POPULAR_MOVIES_API
import com.codebaron.core.SIMILAR_MOVIES
import com.codebaron.domain.models.moviedetails.FilmDetailsData
import com.codebaron.domain.models.movies.AllMovies
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * @author Anyanwu Nicholas(codeBaron)
 * @since 10-09-2022
 */

interface BaseEndPoints {

    @GET(POPULAR_MOVIES_API)
    suspend fun getPopularMovies(
        @Query("api_key", encoded = true) apiKey: String,
        @Query("language", encoded = true) language: String,
        @Query("page", encoded = true) page: String
    ): Response<AllMovies>

    @GET(MOVIE_DETAILS)
    suspend fun getMovieDetails(
        @Path("movie_id", encoded = true) movieId: String,
        @Query("api_key", encoded = true) apiKey: String,
        @Query("language", encoded = true) language: String
    ): Response<FilmDetailsData>

    @GET(SIMILAR_MOVIES)
    suspend fun getSimilarMovies(
        @Path("movie_id", encoded = true) movieId: String,
        @Query("api_key", encoded = true) apiKey: String,
        @Query("language", encoded = true) language: String
    ): Response<AllMovies>
}