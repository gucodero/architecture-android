package com.gucodero.domain.shared.module

import com.gucodero.domain.counter.use_cases.get_counter.GetCounterUseCase
import com.gucodero.domain.counter.use_cases.set_counter.SetCounterUseCase
import com.gucodero.domain.user.use_cases.insert_user.InsertUserUseCase
import com.gucodero.domain.user.use_cases.user_exist.UserExistUserCase
import org.koin.dsl.module

val domainModule = module {
    single { SetCounterUseCase(get()) }
    single { GetCounterUseCase(get()) }
    single { InsertUserUseCase(get()) }
    single { UserExistUserCase(get()) }
}