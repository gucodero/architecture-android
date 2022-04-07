package com.gucodero.architectureandroid.test.main

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.gucodero.architectureandroid.test.TestBottomSheetDialog
import com.gucodero.architectureandroid.test.TestDialog
import com.gucodero.ui.base.ScreenFragment

class MainScreen: ScreenFragment<MainViewModel>(
    clazz = MainViewModel::class
) {

    @Composable
    override fun Screen() {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {
            Button(
                onClick = {
                    TestDialog().show()
                }
            ) {
                   Text(
                       text = "Test Dialog"
                   )
            }
            Spacer(modifier = Modifier.height(12.dp))
            Button(
                onClick = {
                    TestBottomSheetDialog().show()
                }
            ) {
                Text(
                    text = "Test Bottom Sheet Dialog"
                )
            }
        }
    }
}