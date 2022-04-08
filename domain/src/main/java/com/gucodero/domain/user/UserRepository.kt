package com.gucodero.domain.user

import com.gucodero.domain.user.entities.User

interface UserRepository {

    suspend fun insertUser(user: User)

    suspend fun existUser(user: User): Boolean

}