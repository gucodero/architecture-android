package com.gucodero.data.shared.utils

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import timber.log.Timber
import java.lang.Exception

suspend fun <T> executeQuery(
    dispatcher: CoroutineDispatcher = Dispatchers.IO,
    block: suspend () -> T
): T {
    return try {
        withContext(
            context = dispatcher,
            block = {
                block()
            }
        )
    } catch (e: Exception){
        Timber.e(e)
        throw e
    }
}