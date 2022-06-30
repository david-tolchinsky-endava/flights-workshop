package com.endava.flights.model

data class Airplane(
    val id: Int,
    val airplaneModel: AirplaneModel,
    val airplaneState: AirplaneState,
    val seats : List<Seat>
)
