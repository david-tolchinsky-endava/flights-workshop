package com.endava.flights.datasource

import android.text.BoringLayout
import android.util.Log
import com.endava.flights.model.Flight
import com.endava.flights.model.Service
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class FlightImpl(
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) : FlightsRepository {

    override suspend fun getFlights(): List<Flight> {
        val repo = MockFlightsRepository()
        return withContext(dispatcher) {
            repo.getFlights()
        }
    }
}