package com.gucodero.domain.use_cases.get_counter

import com.gucodero.domain.base.FlowUseCase
import com.gucodero.domain.repositories.counter.CounterRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.transform

class GetCounterUseCase(
    private val counterRepository: CounterRepository
): FlowUseCase.OnlyResult<GetCounterResult> {

    override suspend fun invoke(): Flow<GetCounterResult> {
        return counterRepository.getCounterFlow().transform {
            emit(
                GetCounterResult(
                    counter = it
                )
            )
        }
    }

}