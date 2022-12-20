package com.gucodero.ui.utils

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.isUnspecified

inline fun Color.ifUnspecified(block: () -> Color): Color {
    return if(isUnspecified){
        block()
    } else {
        this
    }
}