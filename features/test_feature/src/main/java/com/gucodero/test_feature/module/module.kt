package com.gucodero.test_feature.module

import com.gucodero.test_feature.ui.counter.CounterViewModel
import com.gucodero.test_feature.ui.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module

val moduleLoader = module {
    viewModel { MainViewModel() }
    viewModel { CounterViewModel(get(), get()) }
}

fun loadModules() = loadKoinModules(moduleLoader)