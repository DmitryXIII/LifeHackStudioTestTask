package ru.avacodo.lifehackstudiotesttask.domain.servererror

abstract class LifeHakeErrorBase() {
    abstract fun getErrorMessage(): String

    class ServerError : LifeHakeErrorBase() {
        override fun getErrorMessage(): String {
            return "Ошибка получения данных от сервера"
        }
    }

    class GetCompanyError : LifeHakeErrorBase() {
        override fun getErrorMessage(): String {
            return "Компания с таким id не найдена"
        }
    }
}