package com.gucodero.domain.shared.utils

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import timber.log.Timber

sealed class DataResult<out T> {
    data class Success<out T>(val data: T): DataResult<T>()
    open class Error(
        val code: Int? = 0,
        val message: String? = null,
        val cause: Throwable? = null
    ): DataResult<Nothing>()
    fun <I> map(mapper: (T)->I): DataResult<I> {
        return when(this) {
            is Success -> Success(data = mapper(data))
            is Error -> this
        }
    }

}

sealed class DataError(
    code: Int? = null,
    message: String? = null,
    cause: Throwable? = null
): DataResult.Error(code, message, cause) {

    class HttpError(
        code: Int,
        message: String? = null,
        cause: Throwable? = null,
        val body: String? = null
    ): DataError(code, message, cause){
        fun <T> parseBody(): T?{
            val gson = Gson()
            val type = object : TypeToken<T>() {}.type
            return try {
                gson.fromJson(body, type)
            }catch (ex: Exception){
                Timber.e(ex)
                null
            }
        }
    }

    class NetworkError(message: String? = null, cause: Throwable? = null): Error(
        message = message,
        cause = cause
    )

    class UnknownError(message: String? = null, cause: Throwable? = null): Error(
        message = message,
        cause = cause
    )

    class TimeoutError(message: String? = null, cause: Throwable? = null): Error(
        message = message,
        cause = cause
    )

}