package com.gucodero.ui.common.entities

sealed class StatefulValue<T, E> {

    class Error<T, E>(
        val error: E,
        val value: T? = null
    ): StatefulValue<T, E>()

    class Success<T, E>(
        val value: T,
    ): StatefulValue<T, E>()

    class Loading<T, E>: StatefulValue<T, E>()

    class LoadMore<T, E>(val value: T): StatefulValue<T, E>()

    class Nothing<T, E>: StatefulValue<T, E>()

}