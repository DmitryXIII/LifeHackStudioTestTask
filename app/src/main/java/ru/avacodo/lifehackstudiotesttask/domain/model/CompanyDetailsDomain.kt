package ru.avacodo.lifehackstudiotesttask.domain.model

data class CompanyDetailsDomain(
    val id: String,
    val name: String,
    val logoUrl: String,
    val description: String,
    val lat: Double,
    val lon: Double,
    val siteUrl: String,
    val phone: String,
)