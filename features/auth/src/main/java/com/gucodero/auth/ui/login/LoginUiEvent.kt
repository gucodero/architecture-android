package com.gucodero.auth.ui.login

sealed class LoginUiEvent {
    object ShowLoginError: LoginUiEvent()
    object GoToMain: LoginUiEvent()
}