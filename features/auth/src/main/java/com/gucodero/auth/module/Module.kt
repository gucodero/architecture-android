package com.gucodero.auth.module

import com.gucodero.architectureandroid.utils.createModuleLoader
import com.gucodero.auth.ui.login.LoginViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.core.module.Module
import org.koin.dsl.module

internal val moduleLoader by createModuleLoader(
    uiModule = {
        viewModel { LoginViewModel() }
    },
    dataModule = {

    },
    domainModule = {

    }
)

fun loadModules() = moduleLoader