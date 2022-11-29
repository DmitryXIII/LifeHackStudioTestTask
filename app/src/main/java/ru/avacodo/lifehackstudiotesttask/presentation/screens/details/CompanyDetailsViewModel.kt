package ru.avacodo.lifehackstudiotesttask.presentation.screens.details

import kotlinx.coroutines.launch
import ru.avacodo.lifehackstudiotesttask.domain.model.CompanyDetailsDomain
import ru.avacodo.lifehackstudiotesttask.domain.usecase.GetCompanyDetailsUsecase
import ru.avacodo.lifehackstudiotesttask.presentation.core.AppState
import ru.avacodo.lifehackstudiotesttask.presentation.core.BaseViewModel

class CompanyDetailsViewModel(
    private val usecase: GetCompanyDetailsUsecase,
) : BaseViewModel<CompanyDetailsDomain>() {

    fun getCompanyDetails(companyId: String) {
        super.execute { scope ->
            scope.launch {
                resultState.postValue(AppState.Success(usecase.getCompanyDetails(companyId)))
            }
        }
    }
}