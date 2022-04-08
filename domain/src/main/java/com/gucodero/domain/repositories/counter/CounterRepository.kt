package com.gucodero.domain.repositories.counter

import kotlinx.coroutines.flow.Flow

interface CounterRepository {

    suspend fun setCounter(counter: Int)

    suspend fun getCounter(): Int

    suspend fun getCounterFlow(): Flow<Int>

}