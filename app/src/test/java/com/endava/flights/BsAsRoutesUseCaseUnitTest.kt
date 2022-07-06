package com.endava.flights

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.endava.flights.datasource.AirRoutesRepositoryImpl
import com.endava.flights.usecase.BsAsRoutesUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class BsAsRoutesUseCaseUnitTest {
    @get:Rule
    var coroutineTestRule = MainCoroutineTestRule()

    @get:Rule
    val rule = InstantTaskExecutorRule()

    val bsAsRoutesUseCase = BsAsRoutesUseCase(
        repository = AirRoutesRepositoryImpl(Dispatchers.IO)
    )

    @Test
    fun bSAsRoutesCaseUseShouldGetFiveRoutesTest() = runTest {
        Assert.assertEquals(5, bsAsRoutesUseCase().size)
    }
}