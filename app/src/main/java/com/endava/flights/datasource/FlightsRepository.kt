package com.endava.flights.datasource

import com.endava.flights.model.Flight

interface FlightsRepository {
    suspend fun getFlights() : List<Flight>
}