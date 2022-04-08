package com.gucodero.domain.base

import com.gucodero.domain.base.Parameters as IParameters
import com.gucodero.domain.base.Result as IResult

interface SimpleUseCase {

    interface ParamsAndResult<Parameters: IParameters, Result: IResult>: SimpleUseCase {
        suspend operator fun invoke(params: Parameters): Result
    }

    interface OptionalParamsAndResult<Parameters: IParameters, Result: IResult>: SimpleUseCase {
        suspend operator fun invoke(params: Parameters? = null): Result
    }

    interface OnlyParams<Parameters: IParameters>: SimpleUseCase {
        suspend operator fun invoke(params: Parameters)
    }

    interface OnlyResult<Result: IResult>: SimpleUseCase {
        suspend operator fun invoke(): Result
    }

    interface Empty: SimpleUseCase {
        suspend operator fun invoke()
    }

}