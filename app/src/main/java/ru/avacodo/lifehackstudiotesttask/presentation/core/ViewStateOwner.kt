package ru.avacodo.lifehackstudiotesttask.presentation.core

interface ViewStateOwner<T> {
    fun onStartLoadingAction()
    fun onSuccessAction(result: T)
    fun onErrorAction(error: String)
}