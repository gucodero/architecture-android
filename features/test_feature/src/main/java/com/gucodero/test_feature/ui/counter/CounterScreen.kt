package com.gucodero.test_feature.ui.counter

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gucodero.ui.common.component.AppButton
import com.gucodero.ui.compose.fragment.ScreenFragment

class CounterScreen: ScreenFragment<CounterViewModel>(
    clazz = CounterViewModel::class
) {

    @Composable
    override fun Screen() = with(viewModel){
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
        ) {
            Text(
                text = "${uiState.counter}",
                fontSize = 80.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(bottom = 32.dp)
            )
            Row {
                AppButton(
                    text = "-"
                ) {
                    dismiss()
                }
                Spacer(modifier = Modifier.width(8.dp))
                AppButton(
                    text = "+"
                ) {
                    plus()
                }
            }
        }
    }

}