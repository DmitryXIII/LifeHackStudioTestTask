package ru.avacodo.lifehackstudiotesttask.data

import ru.avacodo.lifehackstudiotesttask.data.remote.CompaniesRepository
import ru.avacodo.lifehackstudiotesttask.domain.lifeHackError
import ru.avacodo.lifehackstudiotesttask.domain.model.CompanyShortDomain
import ru.avacodo.lifehackstudiotesttask.domain.servererror.LifeHakeErrorBase
import ru.avacodo.lifehackstudiotesttask.domain.usecase.GetCompaniesListUsecase

class GetCompaniesListUsecaseImpl(
    private val repository: CompaniesRepository,
) : GetCompaniesListUsecase {
    override suspend fun getCompaniesList(): List<CompanyShortDomain> {
        return repository.getCompaniesList().apply {
            if (this.isEmpty()) lifeHackError(LifeHakeErrorBase.ServerError())
        }
    }
}