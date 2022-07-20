package com.endava.flights

import androidx.lifecycle.ViewModel
import com.endava.flights.datasource.FlightImpl
import com.endava.flights.model.GetFlightsByServicesUseCase
import com.endava.flights.model.Service
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MainFlightViewModel : ViewModel() {
    private lateinit var getCheapestFlightsUseCase : GetFlightsByServicesUseCase

    suspend fun getCheapestFlight(searchingWords : List<Service>) : List<String> {

        getCheapestFlightsUseCase = GetFlightsByServicesUseCase(
            searchingWords, FlightImpl()
        )
        return withContext(Dispatchers.IO){
            getCheapestFlightsUseCase.invoke()
        }
    }
}