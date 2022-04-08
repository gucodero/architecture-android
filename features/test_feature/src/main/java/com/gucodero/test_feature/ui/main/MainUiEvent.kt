package com.gucodero.test_feature.ui.main

import com.gucodero.ui.lifecycle.model.UiEvent

sealed class MainUiEvent: UiEvent {
    object GoToCounterScreen: MainUiEvent()
}