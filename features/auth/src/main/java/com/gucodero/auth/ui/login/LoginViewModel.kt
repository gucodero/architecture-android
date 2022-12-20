package com.gucodero.auth.ui.login

import com.gucodero.ui.common.lifecycle.StatefulViewModel
import com.gucodero.ui.common.util.setUiState

class LoginViewModel(): StatefulViewModel<LoginUiState, LoginUiEvent>(
    state = LoginUiState()
) {

    fun setUsername(username: String){
        setUiState {
            copy(
                username = username
            )
        }
    }

    fun setPassword(password: String){
        setUiState {
            copy(
                password = password
            )
        }
    }

    fun login(){
        LoginUiEvent.GoToMain.send()
    }

}