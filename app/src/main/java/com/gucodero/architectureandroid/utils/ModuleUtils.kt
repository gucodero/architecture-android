package com.gucodero.architectureandroid.utils

import org.koin.core.context.loadKoinModules
import org.koin.core.module.Module
import org.koin.dsl.module

fun createModuleLoader(
    uiModule: Module.() -> Unit,
    dataModule: Module.() -> Unit,
    domainModule: Module.() -> Unit
): Lazy<Unit> {
    return lazy {
        loadKoinModules(
            listOf(
                module { uiModule() },
                module { dataModule() },
                module { domainModule() }
            )
        )
    }
}