package com.gucodero.test_feature.ui.counter

import com.gucodero.domain.counter.use_cases.get_counter.GetCounterUseCase
import com.gucodero.domain.counter.use_cases.set_counter.SetCounterParameters
import com.gucodero.domain.counter.use_cases.set_counter.SetCounterUseCase
import com.gucodero.ui.common.lifecycle.StatefulViewModel
import com.gucodero.ui.common.util.launch
import com.gucodero.ui.common.util.setUiState

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
            setUiState {
                copy(
                    counter = it.counter
                )
            }
        }
    }

}