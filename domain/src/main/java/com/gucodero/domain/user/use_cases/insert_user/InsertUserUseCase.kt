package com.gucodero.domain.user.use_cases.insert_user

import com.gucodero.domain.shared.base.SimpleUseCase
import com.gucodero.domain.user.UserRepository
import com.gucodero.domain.user.mappers.toUser

class InsertUserUseCase(
    private val userRepository: UserRepository
): SimpleUseCase.OnlyParams<InsertUserParameters> {

    override suspend fun invoke(params: InsertUserParameters) {
        userRepository.insertUser(params.toUser())
    }

}