package ru.avacodo.lifehackstudiotesttask.data.remote

import ru.avacodo.lifehackstudiotesttask.data.remote.dto.CompanyDetailsDto
import ru.avacodo.lifehackstudiotesttask.data.remote.dto.CompanyShortDto
import ru.avacodo.lifehackstudiotesttask.domain.model.CompanyDetailsDomain
import ru.avacodo.lifehackstudiotesttask.domain.model.CompanyShortDomain

class ModelMapper {
    fun mapCompanyShortDtoToDomain(companyShortDto: CompanyShortDto): CompanyShortDomain {
        return with(companyShortDto) {
            CompanyShortDomain(
                id = id,
                name = name,
                logoUrl = img
            )
        }
    }

    fun mapCompanyDetailsDtoToDomain(companyDetailsDto: CompanyDetailsDto): CompanyDetailsDomain {
        return with(companyDetailsDto) {
            CompanyDetailsDomain(
                id = id,
                name = name,
                logoUrl = img,
                description = description,
                lat = lat,
                lon = lon,
                siteUrl = www,
                phone = phone
            )
        }
    }
}