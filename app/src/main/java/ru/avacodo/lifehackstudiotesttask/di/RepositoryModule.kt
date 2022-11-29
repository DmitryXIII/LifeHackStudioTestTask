package ru.avacodo.lifehackstudiotesttask.di

import org.koin.dsl.module
import ru.avacodo.lifehackstudiotesttask.data.remote.CompaniesRepository
import ru.avacodo.lifehackstudiotesttask.data.remote.CompaniesRepositoryImpl
import ru.avacodo.lifehackstudiotesttask.data.remote.ModelMapper

val repositoryModule = module {
    single<CompaniesRepository> {
        CompaniesRepositoryImpl(
            remoteDataSource = get(),
            mapper = get())
    }

    single { ModelMapper() }
}