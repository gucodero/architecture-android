package com.gucodero.test_feature.ui.counter

import com.gucodero.domain.use_cases.get_counter.GetCounterUseCase
import com.gucodero.domain.use_cases.set_counter.SetCounterParameters
import com.gucodero.domain.use_cases.set_counter.SetCounterUseCase
import com.gucodero.test_feature.ui.counter.ui_state.CounterUiState
import com.gucodero.ui.lifecycle.StatefulViewModel
import com.gucodero.ui.utils.launch
import kotlinx.coroutines.flow.collect

class CounterViewModel(
    private val getCounterUseCase: GetCounterUseCase,
    private val setCounterUseCase: SetCounterUseCase
): StatefulViewModel<CounterUiState, CounterUiEvent>(
    state = CounterUiState()
) {

    override suspend fun onInit() {
        getCounter()
    }

    fun plus() = launch {
        setCounterUseCase(SetCounterParameters.Add)
    }

    fun dismiss() = launch {
        setCounterUseCase(SetCounterParameters.Subtract)
    }

    private fun getCounter() = launch {
        getCounterUseCase().collect {
            state = state.copy(
                counter = it.counter
            )
        }
    }

}