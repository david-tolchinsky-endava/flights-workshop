package com.endava.flights.usecase

import com.endava.flights.datasource.AirRoutesRepositoryImpl
import com.endava.flights.model.AirRoute

open class BsAsRoutesUseCase(
    private val repository: AirRoutesRepositoryImpl = AirRoutesRepositoryImpl()
) {
    open suspend operator fun invoke(): List<AirRoute> {
        return repository.getAirRoutes(from = "Buenos Aires", to = "")
    }
}