package com.gucodero.domain.counter.use_cases.set_counter

import com.gucodero.domain.shared.base.SimpleUseCase
import com.gucodero.domain.counter.CounterRepository

class SetCounterUseCase(
    private val counterRepository: CounterRepository
): SimpleUseCase.OnlyParams<SetCounterParameters>{

    override suspend fun invoke(params: SetCounterParameters) {
        when(params){
            is SetCounterParameters.Add -> {
                counterRepository.run {
                    setCounter(getCounter() + 1)
                }
            }
            is SetCounterParameters.Subtract -> {
                counterRepository.run {
                    setCounter(getCounter() - 1)
                }
            }
        }
    }

}