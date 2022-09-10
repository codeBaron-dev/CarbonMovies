package com.codebaron.domain.repositories

/**
 * @author Anyanwu Nicholas(codeBaron)
 * @since 10-09-2022
 */
open class ResponseStateHandler<out R> {
    object Loading : ResponseStateHandler<Nothing>()
    data class Success<out T>(val data: T) : ResponseStateHandler<T>()
    data class Exception(val exception: kotlin.Exception) : ResponseStateHandler<Nothing>()
    data class ErrorMessage(val message: String?) : ResponseStateHandler<Nothing>()
}