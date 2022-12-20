package com.gucodero.ui.common.lifecycle.base

import androidx.lifecycle.LiveData

interface WithUiState<UiState> {

    val uiStateLiveData: LiveData<UiState>

    val uiState: UiState

    fun setUiState(uiState: UiState)

}