package com.gucodero.data.shared.persistence.data_storage

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.gucodero.data.shared.utils.executeQuery
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.map

class DataStorageImpl(
    private val context: Context
): DataStorage {

    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = FILE_NAME)

    override suspend fun setString(key: String, value: String) {
        executeQuery {
            context.dataStore.edit {
                it.set(
                    key = stringPreferencesKey(key),
                    value = value
                )
            }
        }
    }

    override suspend fun getString(key: String): String? {
        return executeQuery { context.dataStore.data.firstOrNull()?.get(stringPreferencesKey(key)) }
    }

    override suspend fun getStringFlow(key: String): Flow<String?> {
        return executeQuery {
            context.dataStore.data.map { it[stringPreferencesKey(key)] }
        }
    }

    companion object {
        private const val FILE_NAME = "app_sp"
    }

}