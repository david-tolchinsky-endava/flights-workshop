package com.endava.flights

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.endava.flights.usecase.BsAsRouteCaseUse
import com.endava.flights.viewmodel.RouteViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.*
import kotlinx.coroutines.withContext
import org.junit.Test

import org.junit.Assert.*
import org.junit.Rule
import org.junit.rules.TestWatcher
import org.junit.runner.Description

@ExperimentalCoroutinesApi
class UseCaseUnitTest {
    @Test
    fun bSAsRouteCaseUseGetFiveRoutesTest() = runTest {
        val bsAsRoutes = BsAsRouteCaseUse().getBsAsRoute()
        assertEquals(5, bsAsRoutes.size)
    }
}