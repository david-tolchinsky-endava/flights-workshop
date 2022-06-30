package com.endava.flights.model

import java.util.*

data class Flight(
    val code: String,
    val airRoute: AirRoute,
    val airplane: Airplane,
    val services: List<Service>,
    val departureDate : Date,
    val arriveDate: Date
)