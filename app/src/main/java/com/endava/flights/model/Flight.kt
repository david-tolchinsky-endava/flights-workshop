package com.endava.flights.model

import java.time.LocalDateTime

data class Flight(
    val code: String,
    val airRoute: AirRoute,
    val airplane: Airplane,
    val services: List<Service>,
    val departureDate : LocalDateTime,
    val arriveDate: LocalDateTime
)