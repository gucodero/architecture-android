package com.gucodero.ui.common.lifecycle.base

interface WithUiEvent<UiEvent> {

    suspend fun setOnEvent(onEvent: suspend (UiEvent) -> Unit)

    fun UiEvent.send()

}