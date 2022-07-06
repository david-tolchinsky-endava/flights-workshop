package com.endava.flights.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.endava.flights.model.AirRoute
import com.endava.flights.usecase.BsAsRouteCaseUse
import kotlinx.coroutines.launch

class RouteViewModel(
    val bsAsRouteCaseUse: BsAsRouteCaseUse = BsAsRouteCaseUse()
): ViewModel() {
    private val _bsAsRoutes = MutableLiveData<List<AirRoute>>(listOf())
    val bsAsRoutes = _bsAsRoutes

    fun fetchBsAsRoutes() {
        viewModelScope.launch {
            bsAsRouteCaseUse.getBsAsRoute()
        }
    }
}