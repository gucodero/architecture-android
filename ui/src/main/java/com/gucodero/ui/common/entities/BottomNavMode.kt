package com.gucodero.ui.common.entities

sealed class BottomNavMode {
    object Visible: BottomNavMode()
    object Hide: BottomNavMode()
    object None: BottomNavMode()
}