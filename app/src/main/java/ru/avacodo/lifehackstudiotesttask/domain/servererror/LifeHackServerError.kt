package ru.avacodo.lifehackstudiotesttask.domain.servererror

class LifeHackServerError(private val lifeHackError: LifeHakeErrorBase) : Throwable() {
    override val message: String
        get() = lifeHackError.getErrorMessage()
}