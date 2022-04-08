package com.gucodero.domain.user.use_cases.user_exist

data class UserExistParameters(
    val username: String,
    val password: String
)