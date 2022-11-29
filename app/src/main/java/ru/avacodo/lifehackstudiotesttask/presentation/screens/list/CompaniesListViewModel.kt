package ru.avacodo.lifehackstudiotesttask.presentation.screens.list

import kotlinx.coroutines.launch
import ru.avacodo.lifehackstudiotesttask.domain.model.CompanyShortDomain
import ru.avacodo.lifehackstudiotesttask.domain.usecase.GetCompaniesListUsecase
import ru.avacodo.lifehackstudiotesttask.presentation.core.AppState
import ru.avacodo.lifehackstudiotesttask.presentation.core.BaseViewModel

class CompaniesListViewModel(
    private val usecase: GetCompaniesListUsecase,
) : BaseViewModel<List<CompanyShortDomain>>() {

    fun getCompaniesList() {
        super.execute { scope ->
            scope.launch {
                resultState.postValue(AppState.Success(usecase.getCompaniesList()))
            }
        }
    }
}