package ru.avacodo.lifehackstudiotesttask.domain

import ru.avacodo.lifehackstudiotesttask.domain.servererror.LifeHackServerError
import ru.avacodo.lifehackstudiotesttask.domain.servererror.LifeHakeErrorBase

fun lifeHackError(error: LifeHakeErrorBase): Nothing =
    throw LifeHackServerError(error)