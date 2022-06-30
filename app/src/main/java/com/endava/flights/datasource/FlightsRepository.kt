package com.endava.flights.datasource

import com.endava.flights.model.Flight

interface FlightsRepository {
    fun getFlights() : List<Flight>
}