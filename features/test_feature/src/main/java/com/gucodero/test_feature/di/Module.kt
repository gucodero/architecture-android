package com.gucodero.test_feature.di

import com.gucodero.test_feature.ui.counter.CounterViewModel
import com.gucodero.test_feature.ui.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module

internal val uiModule = module {
    viewModel { MainViewModel() }
    viewModel { CounterViewModel(get(), get()) }
}

internal val domainModule = module {

}

internal val dataModule = module {

}

internal val loadFeatures by lazy {
    loadKoinModules(listOf(uiModule, domainModule, dataModule))
}

fun injectFeatures() = loadFeatures