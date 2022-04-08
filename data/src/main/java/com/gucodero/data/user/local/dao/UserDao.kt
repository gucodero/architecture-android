package com.gucodero.data.user.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.gucodero.data.user.local.entities.UserEntity

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser(user: UserEntity)

    @Query("SELECT count(*) FROM ${UserEntity.TABLE_NAME} WHERE username = :username AND password = :password")
    fun countUser(username: String, password: String): Int

}