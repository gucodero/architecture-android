package com.gucodero.ui.common.lifecycle.base

interface WithLoadingEvent {

    var loading: Boolean

    suspend fun onLoading(listener: (isLoading: Boolean) -> Unit)

}