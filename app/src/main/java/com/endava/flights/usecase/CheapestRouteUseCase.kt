package com.endava.flights.usecase

import com.endava.flights.datasource.AirRoutesRepository
import com.endava.flights.datasource.AirRoutesRepositoryImpl
import com.endava.flights.model.AirRoute

class CheapestRouteUseCase(
    private val airRouteRepository: AirRoutesRepository = AirRoutesRepositoryImpl()
) {
    suspend operator fun invoke(): AirRoute {
        return airRouteRepository.getAllRoutes().minBy { airRoute ->
            airRoute.baseCost.amount
        }
    }
}