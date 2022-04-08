package com.gucodero.data.user.local.mappers

import com.gucodero.data.user.local.entities.UserEntity
import com.gucodero.domain.user.entities.User

fun User.toUserEntity() = UserEntity(
    username = username,
    password = password
)