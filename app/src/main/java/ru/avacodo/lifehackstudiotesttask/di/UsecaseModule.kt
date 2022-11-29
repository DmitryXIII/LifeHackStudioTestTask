package ru.avacodo.lifehackstudiotesttask.di

import org.koin.dsl.module
import ru.avacodo.lifehackstudiotesttask.data.GetCompaniesListUsecaseImpl
import ru.avacodo.lifehackstudiotesttask.data.GetCompanyDetailsUsecaseImpl
import ru.avacodo.lifehackstudiotesttask.domain.usecase.GetCompaniesListUsecase
import ru.avacodo.lifehackstudiotesttask.domain.usecase.GetCompanyDetailsUsecase

val usecaseModule = module {
    single<GetCompaniesListUsecase> { GetCompaniesListUsecaseImpl(repository = get()) }
    single<GetCompanyDetailsUsecase> { GetCompanyDetailsUsecaseImpl(repository = get()) }
}