package com.gucodero.ui.utils

sealed class StatusValue<T>(val value: T) {

    class Error<T>(
        val msg: String,
        val cause: Exception? = null,
        value: T
    ): StatusValue<T>(value = value)

    class Success<T>(value: T): StatusValue<T>(value = value)

    class Loading<T>(value: T): StatusValue<T>(value = value)

    class LoadMore<T>(value: T): StatusValue<T>(value = value)

    class None<T>(value: T): StatusValue<T>(value = value)

    fun setValue(
        newValue: T
    ) = when(this) {
        is Error -> Error(
            msg = msg,
            cause = cause,
            value = newValue
        )
        is LoadMore -> LoadMore(
            value = newValue
        )
        is Loading -> Loading(
            value = newValue
        )
        is None -> None(
            value = newValue
        )
        is Success -> Success(
            value = newValue
        )
    }

    fun toError(
        msg: String,
        cause: Exception? = null,
        newValue: T? = null
    ): Error<T> {
        return Error(
            msg = msg,
            cause = cause,
            value = newValue ?: value
        )
    }

    fun toSuccess(newValue: T = value): Success<T> = Success(newValue)

    fun toLoading(newValue: T = value): Loading<T> = Loading(newValue)

    fun toLoadMore(newValue: T = value): LoadMore<T> = LoadMore(newValue)

    val isLoading get() = this is Loading

    val isLoadMore get() = this is LoadMore

    val isSuccess get() = this is Success

    val isError get() = this is Error

    val isNone get() = this is None
}
