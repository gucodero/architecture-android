package com.gucodero.test_feature.ui.main

import com.gucodero.ui.common.lifecycle.StatelessViewModel
import com.gucodero.ui.common.util.launch
import kotlinx.coroutines.delay

class MainViewModel(): StatelessViewModel<MainUiEvent>() {

    fun goToCounter() = launch {
        loading = true
        delay(2000)
        MainUiEvent.GoToCounterScreen.send()
        loading = false
    }

}