package com.gucodero.data.repositories

import com.gucodero.data.local.counter.CounterLocalDataSource
import com.gucodero.domain.repositories.counter.CounterRepository
import kotlinx.coroutines.flow.Flow

class CounterRepositoryImpl(
    private val local: CounterLocalDataSource
): CounterRepository {

    override suspend fun setCounter(counter: Int) {
        local.setCounter(counter)
    }

    override suspend fun getCounter(): Int {
        return local.getCounter()
    }

    override suspend fun getCounterFlow(): Flow<Int> {
        return local.getCounterFlow()
    }

}