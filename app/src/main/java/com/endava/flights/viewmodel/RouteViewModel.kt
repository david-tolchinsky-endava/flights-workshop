package com.endava.flights.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.endava.flights.model.AirRoute
import com.endava.flights.usecase.BsAsRouteCaseUse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RouteViewModel(
    val bsAsRouteCaseUse: BsAsRouteCaseUse = BsAsRouteCaseUse()
): ViewModel() {
    val bsAsRoutes = MutableLiveData<List<AirRoute>>(listOf())

    fun fetchBsAsRoutes() {
        viewModelScope.launch(Dispatchers.IO) {
            bsAsRoutes.value = bsAsRouteCaseUse.getBsAsRoute()
        }
    }
    fun getBsAsRoute():List<AirRoute> {
        return bsAsRoutes.value?: listOf()
    }
}