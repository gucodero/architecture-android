package com.gucodero.architectureandroid.test

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.gucodero.ui.compose.fragment.ScreenDialog


class TestDialog: ScreenDialog() {

    @Composable
    override fun Screen(){
        Column(
            modifier = Modifier.padding(12.dp)
        ) {
            Text(
                text = "Test Dialog",
                modifier = Modifier.padding(bottom = 12.dp)
            )
            Button(
                onClick = { dismiss() },
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(
                    text = "Cerrar"
                )
            }
        }
    }

}