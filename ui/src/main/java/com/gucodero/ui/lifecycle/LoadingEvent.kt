package com.gucodero.ui.lifecycle

import androidx.compose.runtime.Composable
import kotlinx.coroutines.CoroutineScope

interface LoadingEvent {

    @Composable
    fun OnLoading(listener: suspend CoroutineScope.(isLoading: Boolean) -> Unit)

    fun isLoading(): Boolean

    fun loading(isLoading: Boolean)

    fun loading(isLoading: Boolean, timeMillis: Long)

}