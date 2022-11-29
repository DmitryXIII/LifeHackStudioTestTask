package ru.avacodo.lifehackstudiotesttask.data.remote

import ru.avacodo.lifehackstudiotesttask.domain.model.CompanyDetailsDomain
import ru.avacodo.lifehackstudiotesttask.domain.model.CompanyShortDomain

class CompaniesRepositoryImpl(
    private val remoteDataSource: LifeHackStudioTestApi,
    private val mapper: ModelMapper,
) : CompaniesRepository {
    override suspend fun getCompaniesList(): List<CompanyShortDomain> {
        return remoteDataSource.getCompaniesListAsync()
            .await()
            .map { mapper.mapCompanyShortDtoToDomain(it) }
    }

    override suspend fun getCompanyDetails(companyId: String): List<CompanyDetailsDomain> {
        return remoteDataSource.getCompanyDetailsAsync(companyId)
            .await()
            .map { mapper.mapCompanyDetailsDtoToDomain(it) }
    }
}