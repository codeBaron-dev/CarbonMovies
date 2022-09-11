package com.codebaron.domain.allmoviesrepository

import com.codebaron.domain.models.moviedetails.FilmDetailsData
import com.codebaron.domain.models.movies.Result
import com.codebaron.domain.repositories.BaseEndPoints
import com.codebaron.domain.repositories.RepositoriesManager
import com.codebaron.domain.repositories.ResponseStateHandler
import com.codebaron.domain.repositories.errormanager.ErrorMapper

/**
 * @author Anyanwu Nicholas
 * @since 10-09-2022
 */
class AllMoviesRepositoryImplementation(private val baseEndPoints: BaseEndPoints) :
    RepositoriesManager {

    var errorMapper: ErrorMapper = ErrorMapper()
    private var movies: List<Result>? = emptyList()
    private var movieDetails: FilmDetailsData? = null

    /**
     * This function makes network request to get all movies from remote server
     * @param apiKey
     * @param language
     * @param page
     * @see ResponseStateHandler
     * @see BaseEndPoints
     * @see RepositoriesManager
     */
    override suspend fun getAllMovies(
        apiKey: String,
        language: String,
        page: String
    ): List<Result>? {
        val response = baseEndPoints.getPopularMovies(apiKey, language, page)
        try {
            if (response.isSuccessful) {
                val result = response.body()?.results
                movies = result ?: emptyList()
            } else {
                val error = errorMapper.parseErrorMessage(response.errorBody())
            }
        } catch (exception: Exception) {
        }
        return movies
    }

    /**
     * This function makes network request to get selected movie details from remote server
     * @param apiKey
     * @param language
     * @param movieId
     * @see ResponseStateHandler
     * @see BaseEndPoints
     * @see RepositoriesManager
     */
    override suspend fun getMovieDetails(
        apiKey: String,
        language: String,
        movieId: String
    ): FilmDetailsData? {
        val response = baseEndPoints.getMovieDetails(movieId, apiKey, language)
        try {
            if (response.isSuccessful) {
                val result = response.body()
                movieDetails = result
            } else {
                val error = errorMapper.parseErrorMessage(response.errorBody())
            }
        } catch (exception: Exception) {
        }
        return movieDetails
    }

    /**
     * This function makes network request to get similar movies from remote server
     * @param apiKey
     * @param language
     * @param movieId
     * @see ResponseStateHandler
     * @see BaseEndPoints
     * @see RepositoriesManager
     */
    override suspend fun getSimilarFilms(
        apiKey: String,
        language: String,
        movieId: String
    ): List<Result>? {
        val response = baseEndPoints.getSimilarMovies(movieId, apiKey, language)
        try {
            if (response.isSuccessful) {
                val result = response.body()?.results
                movies = result ?: emptyList()
            } else {
                val error = errorMapper.parseErrorMessage(response.errorBody())
            }
        } catch (exception: Exception) {
        }
        return movies
    }
}