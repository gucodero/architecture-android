package com.gucodero.ui.lifecycle

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

abstract class StatefulViewModel<UiState, UiEvent>(
    state: UiState,
    event: UiEvent? = null
): StatelessViewModel<UiEvent>(event = event) {

    var state by mutableStateOf(
        value = state
    )
        protected set

}