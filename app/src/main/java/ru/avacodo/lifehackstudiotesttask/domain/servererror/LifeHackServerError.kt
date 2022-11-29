package ru.avacodo.lifehackstudiotesttask.domain.servererror

class LifeHackServerError(private val lifeHackError: LifeHakeErrorBase) : Throwable() {
    fun getErrorMessage(): String {
        return lifeHackError.getErrorMessage()
    }
}