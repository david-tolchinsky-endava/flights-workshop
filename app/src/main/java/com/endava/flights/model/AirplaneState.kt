package com.endava.flights.model

import java.time.LocalDateTime

sealed class AirplaneState(val since: LocalDateTime) {
    class Available(since: LocalDateTime, val nextControl: LocalDateTime) : AirplaneState(since)
    class Maintenance(since : LocalDateTime) : AirplaneState(since)
    class OutOfService(since : LocalDateTime) : AirplaneState(since)
}

