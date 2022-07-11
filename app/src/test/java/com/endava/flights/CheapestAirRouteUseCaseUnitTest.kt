package com.endava.flights

import com.endava.flights.datasource.AirRoutesRepositoryImpl
import com.endava.flights.model.AirRoute
import com.endava.flights.model.Money
import com.endava.flights.usecase.CheapestRouteUseCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Test

@ExperimentalCoroutinesApi
class CheapestRoutesUseCaseUnitTest {
    val cheapestRouteUseCase = CheapestRouteUseCase(
        airRouteRepository = AirRoutesRepositoryImpl()
    )

    @Test
    fun bSAsRoutesCaseUseShouldGetFiveRoutesTest() = runTest {
        val expectedCheapestAirRoute = AirRoute(
            "EZE-SCL",
            "Buenos Aires",
            "Santiago",
            Money(190, "USD")
        )

        Assert.assertEquals(
            expectedCheapestAirRoute,
            cheapestRouteUseCase())
    }
}