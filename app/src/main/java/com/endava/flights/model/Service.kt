package com.endava.flights.model

sealed class Service(val name: String, val percent: Float) {
    object Tourist : Service("Tourist", 1.25f)
    object Executive : Service("Business", 2.15f)
    object First : Service("First Class", 3.5f)
}