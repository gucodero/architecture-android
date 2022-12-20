package com.gucodero.ui.common.lifecycle

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.gucodero.ui.common.lifecycle.base.WithUiState

abstract class StatefulViewModel<UiState, UiEvent>(
    event: UiEvent? = null,
    state: UiState
): StatelessViewModel<UiEvent>(
    event = event
), WithUiState<UiState> {

    private val _uiStateLiveData = MutableLiveData(state)
    private var _uiState = mutableStateOf(state)
    override val uiStateLiveData: LiveData<UiState>
        get() = _uiStateLiveData

    override val uiState: UiState by _uiState

    override fun setUiState(uiState: UiState) {
        _uiStateLiveData.value = uiState
        _uiState.value = uiState
    }

}