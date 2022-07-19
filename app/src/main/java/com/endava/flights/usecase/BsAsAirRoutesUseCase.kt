package com.endava.flights.usecase

import com.endava.flights.datasource.AirRoutesRepositoryImpl
import com.endava.flights.model.AirRoute

open class BsAsAirRoutesUseCase(
    private val airRouteRepository: AirRoutesRepositoryImpl = AirRoutesRepositoryImpl()
) {
    open suspend operator fun invoke(): List<AirRoute> {
        return airRouteRepository.getAirRoutes(from = "Buenos Aires", to = "")
    }
}