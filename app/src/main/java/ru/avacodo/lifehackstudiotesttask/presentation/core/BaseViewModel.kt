package ru.avacodo.lifehackstudiotesttask.presentation.core

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ru.avacodo.lifehackstudiotesttask.domain.servererror.LifeHackServerError

private const val DEFAULT_ERROR_MESSAGE = "500: Ошибка на стороне сервера"

abstract class BaseViewModel<ResultType> : ViewModel() {
    protected val resultState = MutableLiveData<AppState<ResultType>>()

    private val coroutineExceptionHandler = CoroutineExceptionHandler { _, throwable ->
        resultState.postValue(AppState.Error(
            if (throwable is LifeHackServerError) {
                throwable.message
            } else {
                DEFAULT_ERROR_MESSAGE
            }
        ))
    }

    protected fun execute(block: (scope: CoroutineScope) -> Unit) {
        resultState.postValue(AppState.Loading())
        viewModelScope.launch(Dispatchers.IO + coroutineExceptionHandler) {
            block.invoke(this)
        }
    }

    fun getData(): LiveData<AppState<ResultType>> = resultState
}