package com.gucodero.auth.module

import com.gucodero.auth.ui.login.LoginViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module

internal val moduleLoader = module {
    viewModel { LoginViewModel() }
}

fun loadModules() = loadKoinModules(moduleLoader)