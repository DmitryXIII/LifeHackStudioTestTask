package ru.avacodo.lifehackstudiotesttask.data.remote

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import ru.avacodo.lifehackstudiotesttask.BuildConfig

class AppOkHTTPClient {
    fun createClient(): OkHttpClient {
        return OkHttpClient.Builder().apply {
            if (BuildConfig.DEBUG) {
                addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            }
        }.build()
    }
}