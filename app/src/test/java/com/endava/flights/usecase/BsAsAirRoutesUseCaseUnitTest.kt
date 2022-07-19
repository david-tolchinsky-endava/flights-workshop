package com.endava.flights.usecase

import com.endava.flights.datasource.AirRoutesRepositoryImpl
import com.endava.flights.usecase.BsAsAirRoutesUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Test

@ExperimentalCoroutinesApi
class BsAsAirRoutesUseCaseUnitTest {
    val bsAsAirRoutesUseCase = BsAsAirRoutesUseCase(
        airRouteRepository = AirRoutesRepositoryImpl(Dispatchers.IO)
    )

    @Test
    fun bSAsRoutesCaseUseShouldGetFiveRoutesTest() = runTest {
        Assert.assertEquals(5, bsAsAirRoutesUseCase().size)
    }
}