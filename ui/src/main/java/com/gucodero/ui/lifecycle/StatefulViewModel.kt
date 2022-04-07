package com.gucodero.ui.lifecycle

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.neverEqualPolicy
import androidx.compose.runtime.setValue
import com.gucodero.ui.lifecycle.model.UiEvent as IEvent
import com.gucodero.ui.lifecycle.model.UiState as IState

abstract class StatefulViewModel<UiState: IState, UiEvent: IEvent>(
    state: UiState,
    event: UiEvent? = null
): StatelessViewModel<UiEvent>(event = event) {

    var state by mutableStateOf(
        value = state
    )
        protected set

}