package com.endava.flights.model

import java.util.*

sealed class AirplaneState(val since: Date) {
    class Available(since: Date, val nextControl: Date) : AirplaneState(since)
    class Maintenance(since : Date) : AirplaneState(since)
    class OutOfService(since : Date) : AirplaneState(since)
}

