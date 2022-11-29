package ru.avacodo.lifehackstudiotesttask.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import ru.avacodo.lifehackstudiotesttask.presentation.screens.details.CompanyDetailsViewModel
import ru.avacodo.lifehackstudiotesttask.presentation.screens.list.CompaniesListViewModel

val viewModelModule = module {
    viewModel { CompaniesListViewModel(usecase = get()) }
    viewModel { CompanyDetailsViewModel(usecase = get()) }
}