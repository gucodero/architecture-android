package com.gucodero.auth.ui.login

import androidx.compose.foundation.layout.Column
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import com.gucodero.auth.module.loadModules
import com.gucodero.ui.base.ScreenFragment

class LoginScreen: ScreenFragment<LoginViewModel>(
    clazz = LoginViewModel::class
) {

    override fun onInit() {
        loadModules()
    }

    @Composable
    override fun Screen() = with(viewModel){
        Column {
            TextField(
                value = state.username,
                onValueChange = {
                    setUsername(it)
                }
            )
            TextField(
                value = state.password,
                onValueChange = {
                    setPassword(it)
                }
            )
        }
    }

}