package com.gucodero.domain.user.mappers

import com.gucodero.domain.user.entities.User
import com.gucodero.domain.user.use_cases.insert_user.InsertUserParameters
import com.gucodero.domain.user.use_cases.user_exist.UserExistParameters

fun InsertUserParameters.toUser() = User(
    username = username,
    password = password
)

fun UserExistParameters.toUser() = User(
    username = username,
    password = password
)