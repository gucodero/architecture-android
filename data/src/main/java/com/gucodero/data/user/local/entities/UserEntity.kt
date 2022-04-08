package com.gucodero.data.user.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = UserEntity.TABLE_NAME
)
data class UserEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val username: String,
    val password: String
) {
    companion object {
        const val TABLE_NAME = "User"
    }
}