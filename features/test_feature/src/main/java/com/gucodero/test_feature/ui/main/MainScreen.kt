package com.gucodero.test_feature.ui.main

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.gucodero.architectureandroid.test.TestBottomSheetDialog
import com.gucodero.architectureandroid.test.TestDialog
import com.gucodero.test_feature.module.injectFeatures
import com.gucodero.ui.base.ScreenFragment
import com.gucodero.ui.components.AppButton
import com.gucodero.ui.utils.navigate

class MainScreen: ScreenFragment<MainViewModel>(
    clazz = MainViewModel::class
) {

    override fun onInit() {
        injectFeatures()
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
                    loading(true, 2000)
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