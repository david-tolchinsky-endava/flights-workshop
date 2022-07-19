package com.endava.flights.usecase

import com.endava.flights.datasource.MockFlightsRepository
import com.endava.flights.model.Service
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Test

@ExperimentalCoroutinesApi
class FilterFlightUseCaseTest {
    val subject = FilterFlightUseCase(
        flightsRepository = MockFlightsRepository()
    )

    @Test
    fun subjectShouldReturnThreeCodes() = runTest {
        Assert.assertEquals(
            listOf(
                "ARG1325",
                "AM404",
                "UC8494"),
            subject( listOf(
                Service.Tourist,
                Service.Executive )))
    }
    @Test
    fun subjectShouldReturnACodes() = runTest {
        Assert.assertEquals(
            listOf(
                "AM404",
                "UC8494"),
            subject( listOf(
                Service.First
            )))
    }
}