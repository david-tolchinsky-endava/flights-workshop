package com.endava.flights.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.endava.flights.model.AirRoute
import com.endava.flights.model.Service
import com.endava.flights.usecase.BsAsAirRoutesUseCase
import com.endava.flights.usecase.CheapestRouteUseCase
import com.endava.flights.usecase.FilterFlightUseCase
import kotlinx.coroutines.launch

class AirRouteViewModel(
    val bsAsRouteUseCase: BsAsAirRoutesUseCase = BsAsAirRoutesUseCase(),
    val cheapestRouteUseCase: CheapestRouteUseCase = CheapestRouteUseCase(),
    val filterFlightsUseCase: FilterFlightUseCase = FilterFlightUseCase()
): ViewModel() {
    private val _bsAsRoutes = MutableLiveData<List<AirRoute>?>(listOf())
    val bsAsRoutes = _bsAsRoutes as LiveData<List<AirRoute>?>

    private val _cheapestRoute: MutableLiveData<AirRoute?> = MutableLiveData<AirRoute?>()
    val cheapestRoute = _cheapestRoute as LiveData<AirRoute?>

    private val _filterFlightCodes = MutableLiveData<List<String>?>()
    val filterFlightCodes = _filterFlightCodes as LiveData<List<String>?>

    fun fetchBsAsRoutes() {
        viewModelScope.launch {
            _bsAsRoutes.value = bsAsRouteUseCase()
        }
    }

    fun getCheapestAirRoute() {
        viewModelScope.launch {
            _cheapestRoute.value = cheapestRouteUseCase()
        }
    }

    fun getFilteredFlightCodes() {
        viewModelScope.launch {
            _filterFlightCodes.value = filterFlightsUseCase(listOf(
                Service.Tourist,
                Service.Executive
            ))
        }
    }
}