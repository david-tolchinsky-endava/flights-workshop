package com.endava.flights.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.endava.flights.model.AirRoute
import com.endava.flights.usecase.BsAsRoutesUseCase
import kotlinx.coroutines.launch

class RouteViewModel(
    val bsAsRouteUseCase: BsAsRoutesUseCase = BsAsRoutesUseCase()
): ViewModel() {
    private val _bsAsRoutesMLD = MutableLiveData<List<AirRoute>?>(listOf())
    val bsAsRoutesLD = _bsAsRoutesMLD as LiveData<List<AirRoute>?>

    fun fetchBsAsRoutes() {
        viewModelScope.launch {
            _bsAsRoutesMLD.value = bsAsRouteUseCase()
        }
    }
}