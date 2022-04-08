package com.gucodero.domain.base

import kotlinx.coroutines.flow.Flow
import com.gucodero.domain.base.Parameters as IParameters
import com.gucodero.domain.base.Result as IResult

interface FlowUseCase {

    interface ParamsAndResult<Parameters: IParameters, Result: IResult>: FlowUseCase {
        suspend operator fun invoke(params: Parameters): Flow<Result>
    }

    interface OptionalParamsAndResult<Parameters: IParameters, Result: IResult>: FlowUseCase {
        suspend operator fun invoke(params: Parameters? = null): Flow<Result>
    }

    interface OnlyResult<Result: IResult>: FlowUseCase {
        suspend operator fun invoke(): Flow<Result>
    }

}