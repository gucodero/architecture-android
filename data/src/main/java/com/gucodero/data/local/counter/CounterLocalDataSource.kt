package com.gucodero.data.local.counter

import com.gucodero.data.local.DataStorage
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.transform

class CounterLocalDataSource(
    private val dataStorage: DataStorage
) {

    suspend fun getCounter(): Int {
        return dataStorage.getString("counter")?.toInt() ?: 0
    }

    suspend fun setCounter(counter: Int) {
        dataStorage.setString("counter", counter.toString())
    }

    suspend fun getCounterFlow(): Flow<Int> {
        return dataStorage.getStringFlow("counter").transform {
            it?.toIntOrNull()?.let { value -> emit(value) }
        }
    }

}