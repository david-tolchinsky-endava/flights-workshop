package com.endava.flights

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.endava.flights.usecase.BsAsRouteCaseUse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.*
import org.junit.Assert
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestWatcher
import org.junit.runner.Description

@ExperimentalCoroutinesApi
class ViewModelUnitTest {
    @get:Rule
    var coroutineTestRule = CoroutineTestRule()

    @get:Rule
    val rule = InstantTaskExecutorRule()
    @Test
    fun routeViewModelFiveRoutesTest() = runTest {
        val bsAsRoutes = BsAsRouteCaseUse().getBsAsRoute()
        Assert.assertEquals(5, bsAsRoutes.size)
    }
}

@ExperimentalCoroutinesApi
class CoroutineTestRule(
    private val dispatcher: TestDispatcher = UnconfinedTestDispatcher()
): TestWatcher() {

    override fun starting(description: Description?) {
        super.starting(description)
        Dispatchers.setMain(dispatcher)
    }

    override fun finished(description: Description?) {
        super.finished(description)
        Dispatchers.resetMain()
    }
}