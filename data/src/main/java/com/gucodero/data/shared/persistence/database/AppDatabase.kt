package com.gucodero.data.shared.persistence.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.gucodero.data.user.local.dao.UserDao
import com.gucodero.data.user.local.entities.UserEntity

@Database(entities = [UserEntity::class], version = 1)
abstract class AppDatabase: RoomDatabase(){
    abstract fun userDao(): UserDao
}