package com.gucodero.domain.counter.use_cases.set_counter

sealed class SetCounterParameters {
    object Add: SetCounterParameters()
    object Subtract: SetCounterParameters()
}