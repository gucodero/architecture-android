package com.gucodero.data.counter

import com.gucodero.data.counter.local.CounterLocalDataSource
import com.gucodero.domain.counter.CounterRepository
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