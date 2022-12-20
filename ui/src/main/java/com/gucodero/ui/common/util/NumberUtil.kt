package com.gucodero.ui.common.util

internal fun Number.format(decimals: Int): String {
    return "%.${decimals}f".format(this.toDouble())
        .replace(",", ".")
        .split(".")
        .mapIndexed { index, s ->
            when(index){
                0 -> s.reversed().chunked(3).joinToString(",").reversed()
                else -> s
            }
        }
        .joinToString(".")
}