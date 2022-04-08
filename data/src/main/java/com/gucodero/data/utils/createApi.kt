package com.gucodero.data.utils

import com.gucodero.data.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private val httpLoggingInterceptor by lazy {
    HttpLoggingInterceptor().apply {
        level = if(BuildConfig.DEBUG){
            HttpLoggingInterceptor.Level.BODY
        } else {
            HttpLoggingInterceptor.Level.NONE
        }
    }
}

val okHttpClient by lazy {
    val builder = OkHttpClient.Builder()
    builder.addInterceptor(httpLoggingInterceptor)
    builder.build()
}

inline fun <reified T> createApi(urlBase: String): T {
    return Retrofit.Builder()
        .client(okHttpClient)
        .baseUrl(urlBase)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(T::class.java)
}