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
import java.time.Duration
import java.time.Instant
import java.time.Period
import java.util.*

class MockFlightsRepository : FlightsRepository {

    override suspend fun getFlights(): List<Flight> {
        return listOf(
            Flight(
                "ARG1325",
                MADRID,
                AIRBUS_A330,
                listOf(Service.Tourist(), Service.Executive()),
                Date.from(Instant.now() + Period.ofDays(10)),
                Date.from(
                    Instant.now() + Period.ofDays(10) + Duration.ofHours(12)
                )
            ),
            Flight(
                "AM404",
                NEW_YORK,
                BOEING_737,
                listOf(Service.Tourist(), Service.Executive(), Service.First()),
                Date.from(Instant.now() + Period.ofDays(1)),
                Date.from(Instant.now() + Period.ofDays(1) + Duration.ofHours(6))
            ),
            Flight(
                "CM323",
                CALI,
                BOEING_737,
                listOf(Service.Tourist()),
                Date.from(Instant.now() + Period.ofDays(2)),
                Date.from(Instant.now() + Period.ofDays(2) + Duration.ofHours(2))
            ),
            Flight(
                "UC8494",
                SANTIAGO,
                BOEING_787,
                listOf(Service.Tourist(), Service.Executive(), Service.First()),
                Date.from(Instant.now() + Period.ofDays(5)),
                Date.from(Instant.now() + Period.ofDays(5) + Duration.ofHours(2))
            )

        )
    }
}