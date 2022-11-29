package ru.avacodo.lifehackstudiotesttask.presentation.core

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.core.view.isVisible
import androidx.viewbinding.ViewBinding

abstract class BaseFragmentWithViewModel<VB : ViewBinding, ResultType>(
    inflateBinding: (
        inflater: LayoutInflater,
        root: ViewGroup?,
        attachToRoot: Boolean,
    ) -> VB,
) : BaseFragment<VB>(inflateBinding), ViewStateOwner<ResultType> {

    abstract val viewModel: BaseViewModel<ResultType>

    protected open val progressBar: ProgressBar? = null

    override fun onStartLoadingAction() {
        progressBar?.apply {
            isVisible = true
        }
    }

    override fun onSuccessAction(result: ResultType) {
        onEndLoading()
    }

    override fun onErrorAction(error: String) {
        onEndLoading()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getData().observe(viewLifecycleOwner) {
            it.handleAction(this)
        }
    }

    private fun onEndLoading() {
        progressBar?.apply {
            isVisible = false
        }
    }
}