package com.gucodero.domain.shared.base

interface SimpleUseCase {

    interface ParamsAndResult<Parameters, Result>: SimpleUseCase {
        suspend operator fun invoke(params: Parameters): Result
    }

    interface OptionalParamsAndResult<Parameters, Result>: SimpleUseCase {
        suspend operator fun invoke(params: Parameters? = null): Result
    }

    interface OnlyParams<Parameters>: SimpleUseCase {
        suspend operator fun invoke(params: Parameters)
    }

    interface OnlyResult<Result>: SimpleUseCase {
        suspend operator fun invoke(): Result
    }

    interface Empty: SimpleUseCase {
        suspend operator fun invoke()
    }

}