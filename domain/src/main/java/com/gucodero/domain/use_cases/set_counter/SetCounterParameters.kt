package com.gucodero.domain.use_cases.set_counter

import com.gucodero.domain.base.Parameters

sealed class SetCounterParameters: Parameters {
    object Add: SetCounterParameters()
    object Subtract: SetCounterParameters()
}