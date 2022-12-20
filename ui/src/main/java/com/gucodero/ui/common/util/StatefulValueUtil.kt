package com.gucodero.ui.common.util

import com.gucodero.ui.common.entities.StatefulValue
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.contract

fun <T, E> StatefulValue<T, E>.getNullableValue(): T? = when(this) {
    is StatefulValue.Error -> value
    is StatefulValue.LoadMore -> value
    is StatefulValue.Loading -> null
    is StatefulValue.Nothing -> null
    is StatefulValue.Success -> value
}

fun <T, E> StatefulValue.Success<T, E>.copy(
    value: T = this.value
) = StatefulValue.Success<T, E>(value)

fun <T, E> StatefulValue.LoadMore<T, E>.copy(
    value: T = this.value
) = StatefulValue.LoadMore<T, E>(value)

fun <T, E> StatefulValue.Error<T, E>.copy(
    error: E = this.error,
    value: T? = this.value
) = StatefulValue.Error(
    error,
    value
)

fun <T, E> statefulNothingOf() = StatefulValue.Nothing<T, E>()

fun <T, E> statefulLoadingOf() = StatefulValue.Loading<T, E>()

fun <T, E> statefulSuccessOf(value: T) = StatefulValue.Success<T, E>(value)

fun <T, E> statefulLoadMoreOf(value: T) = StatefulValue.LoadMore<T, E>(value)

fun <T, E> statefulErrorOf(
    error: E,
    value: T? = null
) = StatefulValue.Error(error, value)

fun <T, E> StatefulValue.Success<T, E>.toError(
    error: E,
    value: T? = this.value
) = StatefulValue.Error(
    error,
    value
)

fun <T, E> StatefulValue.Success<T, E>.toLoadMore(
    value: T = this.value
) = StatefulValue.LoadMore<T, E>(value)

fun <T, E> StatefulValue.LoadMore<T, E>.toError(
    error: E,
    value: T? = this.value
) = StatefulValue.Error(
    error,
    value
)

fun <T, E> StatefulValue.LoadMore<T, E>.toSuccess(
    value: T = this.value
) = StatefulValue.Success<T, E>(value)

inline fun <T, E> StatefulValue.Error<T, E>.toSuccess(
    block: (T?) -> T
): StatefulValue.Success<T, E> = StatefulValue.Success(block(value))

fun <T, E> StatefulValue.Error<T, E>.toLoadMore(
    block: (T?) -> T
): StatefulValue.LoadMore<T, E> = StatefulValue.LoadMore(block(value))

inline fun <T, E> StatefulValue.Error<T, E>.ifNotNull(block: (T) -> Unit): StatefulValue.Error<T, E> {
    if (value != null) {
        block(value)
    }
    return this
}

inline fun <T, E> StatefulValue.Error<T, E>.ifNull(block: (E) -> Unit): StatefulValue.Error<T, E> {
    if (value == null) {
        block(error)
    }
    return this
}

@OptIn(ExperimentalContracts::class)
fun <T, E> StatefulValue<T, E>.isLoading(): Boolean {
    contract {
        returns(true) implies (this@isLoading is StatefulValue.Loading)
    }
    return this is StatefulValue.Loading
}

@OptIn(ExperimentalContracts::class)
fun <T, E> StatefulValue<T, E>.isLoadMore(): Boolean {
    contract {
        returns(true) implies (this@isLoadMore is StatefulValue.LoadMore)
    }
    return this is StatefulValue.LoadMore
}

@OptIn(ExperimentalContracts::class)
fun <T, E> StatefulValue<T, E>.isSuccess(): Boolean {
    contract {
        returns(true) implies (this@isSuccess is StatefulValue.Success)
    }
    return this is StatefulValue.Success
}

@OptIn(ExperimentalContracts::class)
fun <T, E> StatefulValue<T, E>.isError(): Boolean {
    contract {
        returns(true) implies (this@isError is StatefulValue.Error)
    }
    return this is StatefulValue.Error
}

@OptIn(ExperimentalContracts::class)
fun <T, E> StatefulValue<T, E>.isNothing(): Boolean {
    contract {
        returns(true) implies (this@isNothing is StatefulValue.Nothing)
    }
    return this is StatefulValue.Nothing
}