package com.gucodero.data.user.local

import com.gucodero.data.shared.utils.executeQuery
import com.gucodero.data.user.local.dao.UserDao
import com.gucodero.data.user.local.mappers.toUserEntity
import com.gucodero.domain.user.entities.User

class UserLocalDataSource(
    private val dao: UserDao
) {

    suspend fun insertUser(user: User) {
        executeQuery { dao.insertUser(user.toUserEntity()) }
    }

    suspend fun existUser(user: User): Boolean {
        return executeQuery {
            dao.countUser(
                username = user.username,
                password = user.password
            ) == 1
        }
    }

}