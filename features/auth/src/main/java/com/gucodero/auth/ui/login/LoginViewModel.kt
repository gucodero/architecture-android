package com.gucodero.auth.ui.login

import com.gucodero.auth.ui.login.ui_state.LoginUiState
import com.gucodero.ui.lifecycle.StatefulViewModel

class LoginViewModel: StatefulViewModel<LoginUiState, LoginUiEvent>(
    state = LoginUiState()
) {

    fun setUsername(username: String){
        state = state.copy(
            username = username
        )
    }

    fun setPassword(password: String){
        state = state.copy(
            password = password
        )
    }

    fun login(){
        event = LoginUiEvent.GoToMain
    }

}