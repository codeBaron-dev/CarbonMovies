package com.codebaron.domain.models.movies

data class AllMovies(
    val page: Int? = null,
    val results: List<Result>? = null,
    val total_pages: Int? = null,
    val total_results: Int? = null
)