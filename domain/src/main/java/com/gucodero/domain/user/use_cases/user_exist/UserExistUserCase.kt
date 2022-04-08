package com.gucodero.domain.user.use_cases.user_exist

import com.gucodero.domain.shared.base.SimpleUseCase
import com.gucodero.domain.user.UserRepository
import com.gucodero.domain.user.mappers.toUser

class UserExistUserCase(
    private val userRepository: UserRepository
): SimpleUseCase.ParamsAndResult<UserExistParameters, Boolean> {

    override suspend fun invoke(params: UserExistParameters): Boolean {
        return userRepository.existUser(params.toUser())
    }

}