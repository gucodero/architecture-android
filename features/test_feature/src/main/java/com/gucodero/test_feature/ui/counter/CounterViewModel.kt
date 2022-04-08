package com.gucodero.test_feature.ui.counter

import com.gucodero.test_feature.ui.counter.ui_state.CounterUiState
import com.gucodero.ui.lifecycle.StatefulViewModel

class CounterViewModel: StatefulViewModel<CounterUiState, CounterUiEvent>(
    state = CounterUiState()
) {

    fun plus(){
        state = state.copy(
            counter = state.counter + 1
        )
    }

    fun dismiss(){
        state = state.copy(
            counter = state.counter - 1
        )
    }

}