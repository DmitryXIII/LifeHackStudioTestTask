package ru.avacodo.lifehackstudiotesttask.domain.usecase

import ru.avacodo.lifehackstudiotesttask.domain.model.CompanyShortDomain

interface GetCompaniesListUsecase {
    suspend fun getCompaniesList(): List<CompanyShortDomain>
}