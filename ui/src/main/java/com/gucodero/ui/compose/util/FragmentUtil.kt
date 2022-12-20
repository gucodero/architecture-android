package com.gucodero.ui.compose.util

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.gucodero.ui.common.lifecycle.StatelessViewModel
import com.gucodero.ui.common.util.onEvent
import com.gucodero.ui.compose.fragment.ScreenFragment

@Composable
fun <E, V: StatelessViewModel<E>> ScreenFragment<V>.OnEvent(block: suspend (E) -> Unit){
    LaunchedEffect(true){
        onEvent(viewModel, block)
    }
}