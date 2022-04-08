package com.gucodero.data.shared.utils

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase

inline fun <reified T: RoomDatabase> createDatabase(context: Context, name: String): T {
    return Room.databaseBuilder(
        context,
        T::class.java,
        name
    ).build()
}