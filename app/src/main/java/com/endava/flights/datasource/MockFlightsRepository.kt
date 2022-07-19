package com.endava.flights.datasource

import com.endava.flights.datasource.MockAirRoutesRepository.Companion.CALI
import com.endava.flights.datasource.MockAirRoutesRepository.Companion.MADRID
import com.endava.flights.datasource.MockAirRoutesRepository.Companion.NEW_YORK
import com.endava.flights.datasource.MockAirRoutesRepository.Companion.SANTIAGO
import com.endava.flights.datasource.MockAirplaneRepository.Companion.AIRBUS_A330
import com.endava.flights.datasource.MockAirplaneRepository.Companion.BOEING_737
import com.endava.flights.datasource.MockAirplaneRepository.Companion.BOEING_787
import com.endava.flights.model.Flight
import com.endava.flights.model.Service
import java.time.LocalDateTime

class MockFlightsRepository : FlightsRepository {

    override suspend fun getFlights(): List<Flight> {
        return listOf(
            Flight(
                "ARG1325",
                MADRID,
                AIRBUS_A330,
                listOf(Service.Tourist, Service.Executive),
                LocalDateTime.now().plusDays(10),
                LocalDateTime.now().plusDays(10).plusHours(12)

            ),
            Flight(
                "AM404",
                NEW_YORK,
                BOEING_737,
                listOf(Service.Tourist, Service.Executive, Service.First),
                LocalDateTime.now().plusDays(1),
                LocalDateTime.now().plusDays(1).plusHours(6)
            ),
            Flight(
                "CM323",
                CALI,
                BOEING_737,
                listOf(Service.Tourist),
                LocalDateTime.now().plusDays(2),
                LocalDateTime.now().plusDays(2).plusHours(2)
            ),
            Flight(
                "UC8494",
                SANTIAGO,
                BOEING_787,
                listOf(Service.Tourist, Service.Executive, Service.First),
                LocalDateTime.now().plusDays(5),
                LocalDateTime.now().plusDays(5).plusHours(2)
            )
        )
    }
}