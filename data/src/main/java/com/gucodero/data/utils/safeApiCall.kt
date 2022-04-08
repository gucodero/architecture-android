package com.gucodero.data.utils

import com.google.gson.Gson
import com.gucodero.domain.utils.DataError
import com.gucodero.domain.utils.DataResult
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.TimeoutCancellationException
import kotlinx.coroutines.withContext
import okhttp3.ResponseBody
import retrofit2.HttpException
import retrofit2.Response
import timber.log.Timber
import java.net.UnknownHostException

suspend fun <T : Any> safeApiCall(
    dispatcher: CoroutineDispatcher = Dispatchers.IO,
    apiCall: suspend () -> Response<T>
): DataResult<T> {
    return withContext(dispatcher) {
        try {
            val result = apiCall()
            if (result.isSuccessful) {
                DataResult.Success(data = result.body()!!)
            } else {
                val httpError =
                    Gson().fromJson(result.errorBody()?.stringSuspending(), HttpErrorResponse::class.java)
                DataError.HttpError(
                    code = result.code(),
                    message = httpError.message,
                    body = result.errorBody()?.stringSuspending()
                )
            }
        } catch (ex: Exception) {
            Timber.d(ex)
            when (ex) {
                is TimeoutCancellationException -> DataError.TimeoutError(
                    message = ex.message,
                    cause = ex.cause
                )
                is UnknownHostException -> DataError.NetworkError(
                    cause = ex.cause,
                    message = ex.message
                )
                is HttpException -> DataError.HttpError(
                    code = ex.code(),
                    cause = ex.cause,
                    message = ex.message,
                    body = ex.response()?.errorBody()?.stringSuspending()
                )
                else -> DataError.UnknownError(
                    cause = ex.cause,
                    message = ex.message
                )
            }
        }
    }
}

@Suppress("BlockingMethodInNonBlockingContext")
internal suspend fun ResponseBody.stringSuspending() =
    withContext(Dispatchers.IO) { string() }