package com.gucodero.data.di

import com.gucodero.data.local.DataStorage
import com.gucodero.data.local.DataStorageImpl
import com.gucodero.data.local.counter.CounterLocalDataSource
import com.gucodero.data.repositories.CounterRepositoryImpl
import com.gucodero.domain.repositories.counter.CounterRepository
import org.koin.dsl.module

val dataModule = module {
    single<DataStorage> { DataStorageImpl(get()) }
    single { CounterLocalDataSource(get()) }
    single<CounterRepository> { CounterRepositoryImpl(get()) }
}