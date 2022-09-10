package com.codebaron.domain.allmoviesrepository

import androidx.lifecycle.MutableLiveData
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
class AllMoviesRepositoryImplementation(private val baseEndPoints: BaseEndPoints) : RepositoriesManager {

    var errorMapper: ErrorMapper = ErrorMapper()

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
    ): MutableLiveData<ResponseStateHandler<List<Result>?>> {
        val responseState: MutableLiveData<ResponseStateHandler<List<Result>?>> =
            MutableLiveData()
        responseState.postValue(ResponseStateHandler.Loading)
        val response = baseEndPoints.getPopularMovies(apiKey, language, page)
        try {
            if (response.isSuccessful) {
                responseState.postValue(ResponseStateHandler.Success(response.body()?.results))
            } else {
                val error = errorMapper.parseErrorMessage(response.errorBody())
                responseState.postValue(ResponseStateHandler.ErrorMessage(error?.message))
            }
        }catch (exception: Exception) {
            responseState.postValue(ResponseStateHandler.Exception(exception))
        }
        return responseState
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
    ): MutableLiveData<ResponseStateHandler<FilmDetailsData?>> {
        val responseState: MutableLiveData<ResponseStateHandler<FilmDetailsData?>> =
            MutableLiveData()
        responseState.postValue(ResponseStateHandler.Loading)
        val response = baseEndPoints.getMovieDetails(movieId, apiKey, language)
        try {
            if (response.isSuccessful) {
                responseState.postValue(ResponseStateHandler.Success(response.body()))
            } else {
                val error = errorMapper.parseErrorMessage(response.errorBody())
                responseState.postValue(ResponseStateHandler.ErrorMessage(error?.message))
            }
        } catch (exception: Exception) {
            responseState.postValue(ResponseStateHandler.Exception(exception))
        }
        return responseState
    }
}