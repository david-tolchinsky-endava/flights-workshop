package com.endava.flights.usecase

import com.endava.flights.datasource.AirRoutesRepositoryImpl
import com.endava.flights.model.AirRoute

class BsAsRouteCaseUse(
    private val repository: AirRoutesRepositoryImpl = AirRoutesRepositoryImpl()
) {
    suspend fun getBsAsRoute(): List<AirRoute> {
        return repository.getAirRoutes(from = "Buenos Aires", to = "")
    }
}