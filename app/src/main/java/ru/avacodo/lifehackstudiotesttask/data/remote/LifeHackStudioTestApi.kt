package ru.avacodo.lifehackstudiotesttask.data.remote

import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Query
import ru.avacodo.lifehackstudiotesttask.data.remote.dto.CompanyDetailsDto
import ru.avacodo.lifehackstudiotesttask.data.remote.dto.CompanyShortDto


interface LifeHackStudioTestApi {
    @GET("test_task/test.php")
    fun getCompaniesListAsync(): Deferred<List<CompanyShortDto>>

    @GET("test_task/test.php")
    fun getCompanyDetailsAsync(
        @Query("id") companyId: String,
    ): Deferred<List<CompanyDetailsDto>>
}