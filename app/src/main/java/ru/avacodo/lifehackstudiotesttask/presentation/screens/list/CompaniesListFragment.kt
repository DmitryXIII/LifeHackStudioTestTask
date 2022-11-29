package ru.avacodo.lifehackstudiotesttask.presentation.screens.list

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.avacodo.lifehackstudiotesttask.databinding.FragmentCompaniesListBinding
import ru.avacodo.lifehackstudiotesttask.domain.model.CompanyShortDomain
import ru.avacodo.lifehackstudiotesttask.presentation.core.BaseFragmentWithViewModel

class CompaniesListFragment :
    BaseFragmentWithViewModel<FragmentCompaniesListBinding, List<CompanyShortDomain>>(
        FragmentCompaniesListBinding::inflate) {
    override val viewModel by viewModel<CompaniesListViewModel>()
    override val progressBar by lazy { binding.companiesListProgressBar }

    private val companiesListAdapter = CompaniesListAdapter { companyId ->
        navigator.showCompanyDetailsFragment(companyId)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.companiesListRecyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = companiesListAdapter
        }

        if (savedInstanceState == null) {
            viewModel.getCompaniesList()
        }
    }

    override fun onSuccessAction(result: List<CompanyShortDomain>) {
        super.onSuccessAction(result)
        companiesListAdapter.setData(result)
    }
}