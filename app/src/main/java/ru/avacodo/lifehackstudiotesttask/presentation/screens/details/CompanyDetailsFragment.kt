package ru.avacodo.lifehackstudiotesttask.presentation.screens.details

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.avacodo.lifehackstudiotesttask.R
import ru.avacodo.lifehackstudiotesttask.databinding.FragmentCompanyDetailsBinding
import ru.avacodo.lifehackstudiotesttask.domain.model.CompanyDetailsDomain
import ru.avacodo.lifehackstudiotesttask.presentation.core.BaseFragmentWithViewModel
import ru.avacodo.lifehackstudiotesttask.presentation.loadImage

private const val COMPANY_ID_ARG_KEY = "COMPANY_ID_ARG_KEY"
private const val EMPTY_COORDS_VALUE = 0.0

class CompanyDetailsFragment :
    BaseFragmentWithViewModel<FragmentCompanyDetailsBinding, CompanyDetailsDomain>(
        FragmentCompanyDetailsBinding::inflate) {
    override val viewModel by viewModel<CompanyDetailsViewModel>()
    override val progressBar by lazy { binding.companyDetailsProgressBar }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            it.getString(COMPANY_ID_ARG_KEY)?.let { companyId ->
                if (savedInstanceState == null) {
                    viewModel.getCompanyDetails(companyId)
                }
            }
        }
    }

    override fun onSuccessAction(result: CompanyDetailsDomain) {
        super.onSuccessAction(result)
        with(binding) {
            companyDetailsImageView.loadImage(result.logoUrl, false)
            companyDetailsDescriptionTextView.text = result.description
            companyDetailsNameTextView.text = result.name
            companyDetailsPhoneTextView.text = result.phone
            companyDetailsUrlTextView.text = result.siteUrl
            initLocationCard(result)
            companyDetailsLayout.isVisible = true
        }
    }

    private fun initLocationCard(result: CompanyDetailsDomain) {
        binding.companyDetailsLocationCard.apply {
            isVisible = (result.lon != EMPTY_COORDS_VALUE && result.lat != EMPTY_COORDS_VALUE)
            setOnClickListener {
                startActivity(Intent().apply {
                    action = Intent.ACTION_VIEW
                    data = Uri.parse(getString(
                        R.string.maps_uri,
                        result.lat.toString(),
                        result.lon.toString(),
                        result.name))
                })
            }
        }
    }

    companion object {
        fun newInstance(companyId: String): CompanyDetailsFragment {
            return CompanyDetailsFragment().apply {
                arguments = bundleOf(COMPANY_ID_ARG_KEY to companyId)
            }
        }
    }
}