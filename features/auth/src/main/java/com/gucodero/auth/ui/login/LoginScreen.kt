package com.gucodero.auth.ui.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.gucodero.auth.module.loadModules
import com.gucodero.ui.base.ScreenFragment
import com.gucodero.ui.components.AppButton
import com.gucodero.ui.utils.navigate

class LoginScreen: ScreenFragment<LoginViewModel>(
    clazz = LoginViewModel::class
) {

    override fun onInit() {
        loadModules()
    }

    @Composable
    override fun Screen() = with(viewModel){
        OnEvent {
            when(it){
                is LoginUiEvent.GoToMain -> {
                    navigate(LoginScreenDirections.loginScreenToMainScreenAction())
                }
                is LoginUiEvent.ShowLoginError -> {

                }
            }
        }
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
        ) {
            TextField(
                value = state.username,
                onValueChange = {
                    setUsername(it)
                },
                label = {
                    Text(text = "Username")
                },
                modifier = Modifier
                    .padding(bottom = 25.dp)
            )
            TextField(
                value = state.password,
                onValueChange = {
                    setPassword(it)
                },
                label = {
                    Text(text = "Password")
                },
                modifier = Modifier
                    .padding(bottom = 25.dp)
            )
            AppButton(text = "Sign in") {
                login()
            }
        }
    }

}