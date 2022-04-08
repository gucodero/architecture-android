package com.gucodero.data.shared.utils

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

object JSON {
    inline fun<reified T> stringify(value: T) : String{
        val type = object : TypeToken<T>(){}.type
        return Gson().toJson(value, type)
    }

    inline fun<reified T> parse(value: String) : T{
        val type = object : TypeToken<T>(){}.type
        return Gson().fromJson(value, type)
    }
}