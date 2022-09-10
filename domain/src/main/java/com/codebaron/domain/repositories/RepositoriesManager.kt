package com.codebaron.domain.repositories

import androidx.lifecycle.MutableLiveData
import com.codebaron.domain.models.moviedetails.FilmDetailsData
import com.codebaron.domain.models.movies.Result
/**
 * @author Anyanwu Nicholas(codeBaron)
 * @since 10-09-2022
 */
interface RepositoriesManager {
    suspend fun getAllMovies(apiKey: String, language: String, page: String): MutableLiveData<ResponseStateHandler<List<Result>?>>
    suspend fun getMovieDetails(apiKey: String, language: String, movieId: String): MutableLiveData<ResponseStateHandler<FilmDetailsData?>>
}