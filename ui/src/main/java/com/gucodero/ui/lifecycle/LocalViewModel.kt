package com.gucodero.ui.lifecycle

import androidx.compose.runtime.Composable
import androidx.compose.runtime.compositionLocalOf
import androidx.lifecycle.ViewModel

val LocalViewModel = compositionLocalOf<ViewModel> { error("no exist") }

@Composable
inline fun <reified T: ViewModel> localViewModel(): T {
    val result = LocalViewModel.current
    if(result is T){
        return result
    } else {
        throw Exception()
    }
}