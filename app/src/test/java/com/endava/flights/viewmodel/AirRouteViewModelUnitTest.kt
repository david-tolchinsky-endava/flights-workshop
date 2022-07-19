package com.endava.flights.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.endava.flights.MainCoroutineTestRule
import com.endava.flights.model.AirRoute
import com.endava.flights.model.Money
import com.endava.flights.model.Service
import com.endava.flights.usecase.BsAsAirRoutesUseCase
import com.endava.flights.usecase.CheapestRouteUseCase
import com.endava.flights.usecase.FilterFlightUseCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class AirRouteViewModelUnitTest {
    private var subject = AirRouteViewModel(
        bsAsRouteUseCase = MockBsAsAirRouteUseCase(),
        cheapestRouteUseCase = MockCheapestAirRouteUseCase(),
        filterFlightsUseCase = MockFilterFlightUseCase()
    )

    @get:Rule
    var coroutineTestRule = MainCoroutineTestRule()

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @Test
    fun fetchBsAsRoutesShouldStoreFiveRoutesInLiveDataTest() = runTest {
        subject.fetchBsAsRoutes()
        assertEquals(5, subject.bsAsRoutes.value?.size)
    }

    @Test
    fun getCheapestAirRouteTest() = runTest {
        val expectedCheapestAirRoute = AirRoute(
            "EZE-SCL",
            "Buenos Aires",
            "Santiago",
            Money(190, "USD")
        )
        subject.getCheapestAirRoute()
        assertEquals(
            expectedCheapestAirRoute,
            subject.cheapestRoute.value)
    }

    @Test
    fun viewModelShouldStoreThreeCodes() {
        subject.getFilteredFlightCodes()
        assertEquals(
            listOf(
                "ARG1325",
                "AM404",
                "UC8494"
            ),
            subject.filterFlightCodes.value
        )
    }
}

class MockBsAsAirRouteUseCase: BsAsAirRoutesUseCase() {
    override suspend operator fun invoke(): List<AirRoute> {
        return listOf(
            AirRoute("EZE-MAD", "Buenos Aires", "Madrid", Money(1900, "USD")),
            AirRoute("EZE-MIA", "Buenos Aires", "Miami", Money(1600, "USD")),
            AirRoute("EZE-SCL", "Buenos Aires", "Santiago", Money(190, "USD")),
            AirRoute("BUE-RDJ", "Buenos Aires", "Rio De Janeiro", Money(400, "USD")),
            AirRoute("BUE-MEX", "Buenos Aires", "Mexico DF", Money(1200, "USD")))
    }
}

class MockCheapestAirRouteUseCase: CheapestRouteUseCase() {
    override suspend fun invoke(): AirRoute {
        return AirRoute(
            "EZE-SCL",
            "Buenos Aires",
            "Santiago",
            Money(190, "USD")
        )
    }
}

class MockFilterFlightUseCase: FilterFlightUseCase() {
    override suspend fun invoke(services: List<Service>): List<String> {
        return if ( services == listOf(
                Service.Tourist,
                Service.Executive )) {
            listOf("ARG1325", "AM404", "UC8494" )
        } else {
            listOf("ERROR")
        }
    }
}