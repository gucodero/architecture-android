package com.gucodero.test_feature.ui.main

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.lifecycleScope
import com.gucodero.architectureandroid.test.TestBottomSheetDialog
import com.gucodero.architectureandroid.test.TestDialog
import com.gucodero.test_feature.module.loadModules
import com.gucodero.ui.common.component.AppButton
import com.gucodero.ui.common.util.navigate
import com.gucodero.ui.compose.fragment.ScreenFragment
import com.gucodero.ui.compose.util.OnEvent
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainScreen: ScreenFragment<MainViewModel>(
    clazz = MainViewModel::class
) {

    init {
        loadModules()
    }

    @Composable
    override fun Screen() = with(viewModel) {
        OnEvent {
            when(it){
                is MainUiEvent.GoToCounterScreen -> {
                    navigate(MainScreenDirections.mainScreenToCounterScreenAction())
                }
            }
        }
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {
            AppButton(
                text = "Test Dialog",
                onClick = {
                    TestDialog().show()
                }
            )
            Spacer(modifier = Modifier.height(12.dp))
            AppButton(
                text = "Test Bottom Sheet Dialog",
                onClick = {
                    TestBottomSheetDialog().show()
                }
            )
            Spacer(modifier = Modifier.height(12.dp))
            AppButton(
                text = "Loading",
                onClick = {
                    lifecycleScope.launch {
                        loading = true
                        delay(2000)
                        loading = false
                    }
                }
            )
            Spacer(modifier = Modifier.height(12.dp))
            AppButton(
                text = "Go to counter",
                onClick = {
                    goToCounter()
                }
            )
        }
    }
}