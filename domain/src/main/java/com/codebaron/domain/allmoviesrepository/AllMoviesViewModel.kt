package com.codebaron.domain.allmoviesrepository

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codebaron.domain.models.moviedetails.FilmDetailsData
import com.codebaron.domain.models.movies.Result
import com.codebaron.domain.repositories.RepositoriesManager
import com.codebaron.domain.repositories.ResponseStateHandler
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * @author Anyanwu Nicholas(codeBaron)
 * @since 10-09-2022
 * @see RepositoriesManager
 * @see Result
 * @see FilmDetailsData
 * @see ResponseStateHandler
 */
@HiltViewModel
class AllMoviesViewModel @Inject constructor(private val repositoriesManager: RepositoriesManager) :
    ViewModel() {

    private val _allMovies = MutableLiveData<List<Result>?>()
    private val _movieDetails = MutableLiveData<FilmDetailsData?>()
    private val _similarMovies = MutableLiveData<List<Result>>()

    /**
     * This function get result from [RepositoriesManager] and update the UI
     * @param apiKey
     * @param language
     * @param page
     */
    fun getAllMovies(
        apiKey: String,
        language: String,
        page: String,
        mainActivity: Context
    ): LiveData<List<Result>?> {
        viewModelScope.launch {
            _allMovies.postValue(repositoriesManager.getAllMovies(apiKey, language, page, mainActivity))
        }
        return _allMovies
    }

    /**
     * This function get result from [RepositoriesManager] and update the UI
     * @param apiKey
     * @param language
     * @param movieId
     */
    fun getMovieDetails(
        apiKey: String,
        language: String,
        movieId: String
    ): LiveData<FilmDetailsData?> {
        viewModelScope.launch {
            _movieDetails.postValue(
                repositoriesManager.getMovieDetails(
                    apiKey,
                    language,
                    movieId
                )
            )
        }
        return _movieDetails
    }

    /**
     * This function get result from [RepositoriesManager] and update the UI
     * @param apiKey
     * @param language
     * @param movieId
     */
    fun getSimilarMovies(
        apiKey: String,
        language: String,
        movieId: String
    ): LiveData<List<Result>> {
        viewModelScope.launch {
            _similarMovies.postValue(repositoriesManager.getSimilarFilms(apiKey, language, movieId))
        }
        return _similarMovies
    }
}