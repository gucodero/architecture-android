package com.gucodero.test_feature.ui.main

import com.gucodero.ui.lifecycle.StatelessViewModel
import com.gucodero.ui.utils.launch
import kotlinx.coroutines.delay

class MainViewModel: StatelessViewModel<MainUiEvent>() {

    fun goToCounter() = launch {
        loading = true
        delay(2000)
        event = MainUiEvent.GoToCounterScreen
        loading = false
    }

}