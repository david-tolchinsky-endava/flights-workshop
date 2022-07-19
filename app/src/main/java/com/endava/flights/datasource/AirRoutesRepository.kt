package com.endava.flights.datasource

import com.endava.flights.model.AirRoute

interface AirRoutesRepository {
    suspend fun getAllRoutes(): List<AirRoute>
    suspend fun getAirRoutes(from: String, to: String): List<AirRoute>
}
