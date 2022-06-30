package com.endava.flights.datasource

import com.endava.flights.model.Airplane

interface AirplaneRepository {
    suspend fun getAirplanes(): List<Airplane>
}