package ru.avacodo.lifehackstudiotesttask.presentation.core

interface AppScreensNavigator {
    fun showCompaniesListFragment()
    fun showCompanyDetailsFragment(companyId: String)
}