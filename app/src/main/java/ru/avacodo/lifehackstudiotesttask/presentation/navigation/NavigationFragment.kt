package ru.avacodo.lifehackstudiotesttask.presentation.navigation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import ru.avacodo.lifehackstudiotesttask.R
import ru.avacodo.lifehackstudiotesttask.databinding.FragmentNavigationBinding
import ru.avacodo.lifehackstudiotesttask.presentation.core.AppScreensNavigator
import ru.avacodo.lifehackstudiotesttask.presentation.core.BaseFragment
import ru.avacodo.lifehackstudiotesttask.presentation.screens.details.CompanyDetailsFragment
import ru.avacodo.lifehackstudiotesttask.presentation.screens.list.CompaniesListFragment

private const val DEFAULT_BACKSTACK_NAME = "DEFAULT_BACKSTACK"

class NavigationFragment :
    BaseFragment<FragmentNavigationBinding>(FragmentNavigationBinding::inflate),
    AppScreensNavigator {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (savedInstanceState == null) {
            showCompaniesListFragment()
        }
    }

    override fun showCompaniesListFragment() {
        navigateToDestination(CompaniesListFragment())
    }

    override fun showCompanyDetailsFragment(companyId: String) {
        navigateToDestination(CompanyDetailsFragment.newInstance(companyId), true)
    }

    private fun navigateToDestination(
        destination: Fragment,
        isRequiredToAddToBackStack: Boolean = false,
    ) {
        parentFragmentManager
            .beginTransaction().apply {
                replace(R.id.navigation_container, destination)
                if (isRequiredToAddToBackStack) {
                    addToBackStack(DEFAULT_BACKSTACK_NAME)
                }
            }.commit()
    }
}