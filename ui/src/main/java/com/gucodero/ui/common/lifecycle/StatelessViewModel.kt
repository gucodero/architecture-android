package com.gucodero.ui.common.lifecycle

import androidx.lifecycle.ViewModel
import com.gucodero.ui.common.lifecycle.base.WithLoadingEvent
import com.gucodero.ui.common.lifecycle.base.WithUiEvent
import com.gucodero.ui.common.util.launch
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.trySendBlocking
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.receiveAsFlow

abstract class StatelessViewModel<Event>(
    event: Event? = null
): ViewModel(), WithUiEvent<Event>, WithLoadingEvent {

    private val eventChannel = Channel<Event>(Channel.BUFFERED)

    private val _loading = MutableStateFlow(false)

    override var loading
        get(): Boolean {
            return _loading.value
        }
        set(value) {
            _loading.tryEmit(value)
        }

    override suspend fun setOnEvent(onEvent: suspend (Event) -> Unit){
        eventChannel.receiveAsFlow().collectLatest(onEvent)
    }

    final override fun Event.send(){
        eventChannel.trySendBlocking(this)
    }

    override suspend fun onLoading(listener: (isLoading: Boolean) -> Unit){
        _loading.collectLatest {
            listener(it)
        }
    }

    init {
        event?.send()
        launch {
            onInit()
        }
    }

    open suspend fun onInit(){}

}