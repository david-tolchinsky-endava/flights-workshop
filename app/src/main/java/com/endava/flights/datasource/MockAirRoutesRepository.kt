package com.endava.flights.datasource

import com.endava.flights.model.AirRoute
import com.endava.flights.model.Money

class MockAirRoutesRepository : AirRoutesRepository {

    companion object {
        val MADRID = AirRoute("EZE-MAD", "Buenos Aires", "Madrid", Money(1900, "USD"))
        val MIAMI = AirRoute("EZE-MIA", "Buenos Aires", "Miami", Money(1600, "USD"))
        val NEW_YORK = AirRoute("MEX-NYC", "Mexico DF", "New york", Money(600, "USD"))
        val CALI = AirRoute("PTY-CLO", "Panama", "Cali", Money(300, "USD"))
        val SANTIAGO = AirRoute("EZE-SCL", "Buenos Aires", "Santiago", Money(190, "USD"))
        val RIO = AirRoute("BUE-RDJ", "Buenos Aires", "Rio De Janeiro", Money(400, "USD"))
        val DF = AirRoute("BUE-MEX", "Buenos Aires", "Mexico DF", Money(1200, "USD"))
    }

    override suspend fun getAirRoutes(from: String, to: String): List<AirRoute> {
        return listOf(MADRID, MIAMI, NEW_YORK, CALI, SANTIAGO, RIO, DF)
    }
}