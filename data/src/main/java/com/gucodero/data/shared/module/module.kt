package com.gucodero.data.shared.module

import com.gucodero.data.counter.CounterRepositoryImpl
import com.gucodero.data.counter.local.CounterLocalDataSource
import com.gucodero.data.shared.persistence.data_storage.DataStorage
import com.gucodero.data.shared.persistence.data_storage.DataStorageImpl
import com.gucodero.data.shared.persistence.database.AppDatabase
import com.gucodero.data.shared.utils.createDatabase
import com.gucodero.data.shared.utils.getDatabase
import com.gucodero.data.user.UserRepositoryImpl
import com.gucodero.data.user.local.UserLocalDataSource
import com.gucodero.domain.counter.CounterRepository
import com.gucodero.domain.user.UserRepository
import org.koin.dsl.module

val dataModule = module {
    single<DataStorage> { DataStorageImpl(get()) }
    single {
        createDatabase<AppDatabase>(
            context = get(),
            name = "app_database"
        )
    }

    single { getDatabase<AppDatabase>().userDao() }
    single { UserLocalDataSource(get()) }
    single<UserRepository> { UserRepositoryImpl(get()) }
    single { CounterLocalDataSource(get()) }
    single<CounterRepository> { CounterRepositoryImpl(get()) }
}