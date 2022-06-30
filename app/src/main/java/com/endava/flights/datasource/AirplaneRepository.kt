package com.endava.flights.datasource

import com.endava.flights.model.Airplane

interface AirplaneRepository {
    fun getAirplanes(): List<Airplane>
}