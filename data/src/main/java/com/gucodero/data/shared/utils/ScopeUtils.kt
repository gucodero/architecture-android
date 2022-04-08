package com.gucodero.data.shared.utils

import org.koin.core.scope.Scope

inline fun <reified T> Scope.getDatabase(): T {
    return get()
}