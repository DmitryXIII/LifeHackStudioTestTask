package ru.avacodo.lifehackstudiotesttask.di

import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.avacodo.lifehackstudiotesttask.data.remote.AppOkHTTPClient
import ru.avacodo.lifehackstudiotesttask.data.remote.LifeHackStudioTestApi

private const val BASE_REMOTE_DATASOURCE_URL = "https://lifehack.studio/"

val retrofitModule = module {
    single<LifeHackStudioTestApi> {
        Retrofit.Builder().apply {
            baseUrl(BASE_REMOTE_DATASOURCE_URL)
            client(AppOkHTTPClient().createClient())
            addCallAdapterFactory(CoroutineCallAdapterFactory())
            addConverterFactory(GsonConverterFactory.create(GsonBuilder().setLenient().create()))
        }.build().create(LifeHackStudioTestApi::class.java)
    }
}