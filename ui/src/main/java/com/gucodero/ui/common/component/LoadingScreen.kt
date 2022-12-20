package com.gucodero.ui.common.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.gucodero.ui.compose.fragment.ScreenDialog

class LoadingScreen: ScreenDialog(
    fullScreen = true,
    isCancelable = false
) {

    @Composable
    override fun Screen(){
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ){
            CircularProgressIndicator()
        }
    }

}