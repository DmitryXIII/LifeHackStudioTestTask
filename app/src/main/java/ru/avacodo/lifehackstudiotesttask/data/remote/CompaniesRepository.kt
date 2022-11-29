package ru.avacodo.lifehackstudiotesttask.data.remote

import ru.avacodo.lifehackstudiotesttask.domain.model.CompanyDetailsDomain
import ru.avacodo.lifehackstudiotesttask.domain.model.CompanyShortDomain

interface CompaniesRepository {
    suspend fun getCompaniesList(): List<CompanyShortDomain>
    suspend fun getCompanyDetails(companyId: String): List<CompanyDetailsDomain>
}