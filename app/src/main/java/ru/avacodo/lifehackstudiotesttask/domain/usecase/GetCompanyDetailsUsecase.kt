package ru.avacodo.lifehackstudiotesttask.domain.usecase

import ru.avacodo.lifehackstudiotesttask.domain.model.CompanyDetailsDomain

interface GetCompanyDetailsUsecase {
    suspend fun getCompanyDetails(): CompanyDetailsDomain
}