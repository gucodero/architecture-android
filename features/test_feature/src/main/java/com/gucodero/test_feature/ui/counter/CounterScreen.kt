package com.gucodero.test_feature.ui.counter

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.gucodero.ui.base.ScreenFragment
import com.gucodero.ui.components.AppButton

class CounterScreen: ScreenFragment<CounterViewModel>(
    clazz = CounterViewModel::class
) {

    @Composable
    override fun Screen() = with(viewModel){
        Column {
            Text(text = "Counter: ${state.counter}")
            AppButton(text = "Aumentar") {
                plus()
            }
            AppButton(text = "Disminuir") {
                dismiss()
            }
        }
    }

}