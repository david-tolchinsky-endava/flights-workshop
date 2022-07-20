package com.endava.flights.model

import com.endava.flights.datasource.FlightsRepository

class GetFlightsByServicesUseCase(var services: List<Service>, var repo: FlightsRepository) {

    suspend operator fun invoke(): List<String> {
        val flightList = repo.getFlights()

        return flightList.filter {
            it.services.containsAll(services)
        }.map { it.code }
    }
}