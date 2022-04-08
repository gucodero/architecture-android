package com.gucodero.ui.utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.NonCancellable
import kotlinx.coroutines.launch

fun ViewModel.launchNonCancellable(block: suspend CoroutineScope.() -> Unit) {
    viewModelScope.launch(
        block = block,
        context = Dispatchers.Main + NonCancellable
    )
}

fun ViewModel.launch(block: suspend CoroutineScope.() -> Unit){
    viewModelScope.launch(
        block = block,
        context = Dispatchers.Main
    )
}