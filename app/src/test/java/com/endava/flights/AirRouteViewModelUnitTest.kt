package com.endava.flights

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.endava.flights.model.AirRoute
import com.endava.flights.model.Money
import com.endava.flights.usecase.BsAsAirRoutesUseCase
import com.endava.flights.viewmodel.AirRouteViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class AirRouteViewModelUnitTest {
    private var airRouteViewModel: AirRouteViewModel? = null

    @get:Rule
    var coroutineTestRule = MainCoroutineTestRule()

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @Before
    fun setup() {
        airRouteViewModel = AirRouteViewModel(MockBsAsAirRouteUseCase())
    }

    @Test
    fun fetchBsAsRoutesShouldStoreFiveRoutesInLiveDataTest() = runTest {
        airRouteViewModel?.fetchBsAsRoutes()
        assertEquals(5, airRouteViewModel?.bsAsRoutesLD?.value?.size)
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