package com.gucodero.data.shared.persistence.data_storage

import kotlinx.coroutines.flow.Flow

interface DataStorage {
    suspend fun setString(key: String, value: String)
    suspend fun getString(key: String): String?
    suspend fun getStringFlow(key: String): Flow<String?>
}