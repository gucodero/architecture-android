package com.gucodero.ui.lifecycle

import android.util.Log
import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gucodero.ui.utils.launch
import kotlinx.coroutines.*

abstract class StatelessViewModel<Event>(
    event: Event? = null
): ViewModel(), LoadingEvent {

    protected var loading by mutableStateOf(false)

    private var listener: (suspend CoroutineScope.(Event) -> Unit)? = null

    protected var event: Event? = null
        set(value) {
            field = value
            listener?.let {
                try {
                    viewModelScope.launch(
                        context = NonCancellable,
                        block = {
                            field?.let { event ->
                                it(this, event)
                            }
                        }
                    )
                }catch (ex: java.lang.Exception){
                    Log.w("OnEvent", ex)
                }
            }
        }

    @Composable
    fun OnEvent(listener: suspend CoroutineScope.(Event) -> Unit){
        LaunchedEffect(true){
            this@StatelessViewModel.listener = listener
        }
    }

    @Composable
    override fun OnLoading(listener: suspend CoroutineScope.(isLoading: Boolean) -> Unit){
        LaunchedEffect(loading){
            listener(loading)
        }
    }

    override fun isLoading(): Boolean = loading

    override fun loading(isLoading: Boolean) {
        loading = isLoading
    }

    override fun loading(isLoading: Boolean, timeMillis: Long) {
        launch {
            loading = isLoading
            if(loading){
                delay(timeMillis)
                loading = false
            }
        }
    }

    init {
        this.event = event
        launch {
            onInit()
        }
    }

    open suspend fun onInit(){}

}