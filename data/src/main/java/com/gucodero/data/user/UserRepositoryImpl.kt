package com.gucodero.data.user

import com.gucodero.data.user.local.UserLocalDataSource
import com.gucodero.domain.user.entities.User
import com.gucodero.domain.user.UserRepository

class UserRepositoryImpl(
    private val local: UserLocalDataSource
): UserRepository {

    override suspend fun insertUser(user: User) {
        local.insertUser(user)
    }

    override suspend fun existUser(user: User): Boolean {
        return local.existUser(user)
    }

}