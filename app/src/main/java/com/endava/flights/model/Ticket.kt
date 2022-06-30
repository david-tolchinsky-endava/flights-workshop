package com.endava.flights.model

import com.endava.flights.model.Passenger

data class Ticket(val id: Int, val passenger: Passenger, val seat: String, val purchaseId: Int)