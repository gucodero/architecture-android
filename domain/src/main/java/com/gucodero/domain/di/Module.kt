package com.gucodero.domain.di

import com.gucodero.domain.use_cases.get_counter.GetCounterUseCase
import com.gucodero.domain.use_cases.set_counter.SetCounterUseCase
import org.koin.dsl.module

val domainModule = module {
    single { SetCounterUseCase(get()) }
    single { GetCounterUseCase(get()) }
}