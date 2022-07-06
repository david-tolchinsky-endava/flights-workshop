package com.endava.flights.usecase

import com.endava.flights.datasource.AirRoutesRepositoryImpl
import com.endava.flights.model.AirRoute
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class BsAsRouteCaseUse(
    private val repository: AirRoutesRepositoryImpl = AirRoutesRepositoryImpl(),
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) {
    suspend fun getBsAsRoute(): List<AirRoute> {
        return withContext(dispatcher) {
            repository.getAirRoutes(from = "Buenos Aires", to = "")
        }
    }
}