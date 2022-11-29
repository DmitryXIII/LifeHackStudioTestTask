package ru.avacodo.lifehackstudiotesttask.data

import ru.avacodo.lifehackstudiotesttask.data.remote.CompaniesRepository
import ru.avacodo.lifehackstudiotesttask.domain.lifeHackError
import ru.avacodo.lifehackstudiotesttask.domain.model.CompanyDetailsDomain
import ru.avacodo.lifehackstudiotesttask.domain.servererror.LifeHakeErrorBase
import ru.avacodo.lifehackstudiotesttask.domain.usecase.GetCompanyDetailsUsecase

class GetCompanyDetailsUsecaseImpl(
    private val repository: CompaniesRepository,
) : GetCompanyDetailsUsecase {
    override suspend fun getCompanyDetails(companyId: String): CompanyDetailsDomain {
        val result = repository.getCompanyDetails(companyId)
        if (result.isEmpty()) lifeHackError(LifeHakeErrorBase.GetCompanyError())
        return result.first()
    }
}