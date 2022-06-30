package com.endava.flights.model

sealed class Service(val name: String, val percent: Float) {
    class Tourist : Service("Tourist", 1.25f)
    class Executive : Service("Business", 2.15f)
    class First : Service("First Class", 3.5f)
}