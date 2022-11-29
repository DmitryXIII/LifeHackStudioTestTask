package ru.avacodo.lifehackstudiotesttask.presentation.core

sealed class AppState<T> {
    abstract fun handleAction(
        fragment: ViewStateOwner<T>,
    )

    class Loading<T> : AppState<T>() {
        override fun handleAction(fragment: ViewStateOwner<T>) {
            fragment.onStartLoadingAction()
        }
    }

    class Success<T>(private val result: T) : AppState<T>() {
        override fun handleAction(fragment: ViewStateOwner<T>) {
            fragment.onSuccessAction(result)
        }
    }

    class Error<T>(private val error: String) : AppState<T>() {
        override fun handleAction(fragment: ViewStateOwner<T>) {
            fragment.onErrorAction(error)
        }
    }
}