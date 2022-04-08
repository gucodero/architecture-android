package com.gucodero.ui.base

abstract class ScreenDialog(
    fullScreen: Boolean = false,
    animation: Int? = null,
    isCancelable: Boolean = true
): BaseFragment(
    fullScreen = fullScreen,
    animation = animation,
    isCancelable = isCancelable
)