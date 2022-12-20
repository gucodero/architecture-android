package com.gucodero.ui.common.util

import com.gucodero.ui.common.lifecycle.base.WithUiState

inline fun <UiState> WithUiState<UiState>.setUiState(block: UiState.() -> UiState){
    setUiState(uiState.block())
}