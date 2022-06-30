package com.endava.flights.datasource

import com.endava.flights.model.AirRoute

interface AirRoutesRepository {
    fun getAirRoutes(from: String, to: String): List<AirRoute>
}
