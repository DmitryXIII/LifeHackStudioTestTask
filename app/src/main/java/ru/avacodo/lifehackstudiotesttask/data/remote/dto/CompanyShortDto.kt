package ru.avacodo.lifehackstudiotesttask.data.remote.dto

import com.google.gson.annotations.SerializedName

data class CompanyShortDto(
    @SerializedName("id")
    val id: String,
    @SerializedName("img")
    val img: String,
    @SerializedName("name")
    val name: String,
)