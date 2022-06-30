package com.endava.flights.model

import com.endava.flights.model.Money

data class Purchase(val id : Int, val cost: Money, val payment: String, val flightCode : String)