package com.codebaron.domain.internet.handler

/**
 * @author Anyanwu Nicholas(codeBaron)
 * @since 10-09-2022
 */
open class InternetConnectionHandler<out R> {

    data class IsInternetAvailable<out T>(val isAvailable: Boolean) : InternetConnectionHandler<T>()

    data class IsInternetConnectionTypeChanged<out T>(val isChanged: Boolean) :
        InternetConnectionHandler<T>()

    data class IsInternetConnectionLost<out T>(val isLost: Boolean) :
        InternetConnectionHandler<T>()
}