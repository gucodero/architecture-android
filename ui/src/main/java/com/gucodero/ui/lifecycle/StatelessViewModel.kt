package com.gucodero.ui.lifecycle

import android.util.Log
import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.*
import com.gucodero.ui.lifecycle.model.UiEvent as IEvent

abstract class StatelessViewModel<Event: IEvent>(
    event: Event? = null
): ViewModel() {

    var loading by mutableStateOf(false)

    private var listener: (suspend CoroutineScope.(Event?) -> Unit)? = null

    protected var event: Event? = null
        set(value) {
            field = value
            listener?.let {
                try {
                    viewModelScope.launch(
                        context = NonCancellable,
                        block = {
                            it(this, field)
                        }
                    )
                }catch (ex: java.lang.Exception){
                    Log.w("OnEvent", ex)
                }
            }
        }

    @Composable
    fun OnEvent(listener: suspend CoroutineScope.(Event?) -> Unit){
        LaunchedEffect(true){
            this@StatelessViewModel.listener = listener
        }
    }

    fun launch(block: suspend CoroutineScope.() -> Unit){
        viewModelScope.launch(
            block = block,
            context = Dispatchers.Main
        )
    }

    fun launchNonCancellable(block: suspend CoroutineScope.() -> Unit){
        viewModelScope.launch(
            block = block,
            context = Dispatchers.Main + NonCancellable
        )
    }

    init {
        this.event = event
        launch {
            onInit()
        }
    }

    open suspend fun onInit(){}

}