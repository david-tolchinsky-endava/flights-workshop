package com.endava.flights.usecase

import com.endava.flights.datasource.FlightsRepository
import com.endava.flights.datasource.MockFlightsRepository
import com.endava.flights.model.Service

class FilteredFlightUseCase(
    private val flightsRepository: FlightsRepository = MockFlightsRepository(),
) {
    suspend operator fun invoke(services: List<Service>): List<String> {
        return flightsRepository
            .getFlights()
            .filter { flight ->
                flight.services.containsAll( services)
            }
//            .filter { flight ->
//                services.all { aGivenService ->
//                    flight.services.any { flightService ->
//                        flightService == aGivenService
//                    }
//                }
//            }
            .map { flight -> flight.code }
    }
}