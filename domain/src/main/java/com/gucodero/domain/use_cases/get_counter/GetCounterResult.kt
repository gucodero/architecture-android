package com.gucodero.domain.use_cases.get_counter

import com.gucodero.domain.base.Result

data class GetCounterResult(
    val counter: Int
): Result