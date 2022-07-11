package com.endava.flights.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.endava.flights.model.AirRoute
import com.endava.flights.usecase.BsAsAirRoutesUseCase
import com.endava.flights.usecase.CheapestRouteUseCase
import kotlinx.coroutines.launch

class AirRouteViewModel(
    val bsAsRouteUseCase: BsAsAirRoutesUseCase = BsAsAirRoutesUseCase(),
    val cheapestRouteUseCase: CheapestRouteUseCase = CheapestRouteUseCase()
): ViewModel() {
    private val _bsAsRoutesMLD = MutableLiveData<List<AirRoute>?>(listOf())
    val bsAsRoutesLD = _bsAsRoutesMLD as LiveData<List<AirRoute>?>

    private val _cheapestRouteMLD: MutableLiveData<AirRoute?> = MutableLiveData<AirRoute?>()
    val cheapestRouteLD = _cheapestRouteMLD as LiveData<AirRoute?>

    fun fetchBsAsRoutes() {
        viewModelScope.launch {
            _bsAsRoutesMLD.value = bsAsRouteUseCase()
        }
    }

    fun getCheapestAirRoute() {
        viewModelScope.launch {
            _cheapestRouteMLD.value = cheapestRouteUseCase()
        }
    }
}