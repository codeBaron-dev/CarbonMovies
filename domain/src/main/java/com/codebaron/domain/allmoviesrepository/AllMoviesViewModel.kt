package com.codebaron.domain.allmoviesrepository

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

    private val _allMovies = MutableLiveData<ResponseStateHandler<List<Result>?>>()
    private val _movieDetails = MutableLiveData<ResponseStateHandler<FilmDetailsData?>>()

    /**
     * This function get result from [RepositoriesManager] and update the UI
     * @param apiKey
     * @param language
     * @param page
     */
    fun getAllMovies(
        apiKey: String,
        language: String,
        page: String
    ): MutableLiveData<ResponseStateHandler<List<Result>?>> {
        viewModelScope.launch {
            _allMovies.postValue(repositoriesManager.getAllMovies(apiKey, language, page).value)
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
    ): MutableLiveData<ResponseStateHandler<FilmDetailsData?>> {
        viewModelScope.launch {
            _movieDetails.postValue(
                repositoriesManager.getMovieDetails(
                    apiKey,
                    language,
                    movieId
                ).value
            )
        }
        return _movieDetails
    }
}