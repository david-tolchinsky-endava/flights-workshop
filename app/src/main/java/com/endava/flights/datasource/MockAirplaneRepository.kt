package com.endava.flights.datasource

import android.os.Build
import androidx.annotation.RequiresApi
import com.endava.flights.model.Airplane
import com.endava.flights.model.AirplaneModel
import com.endava.flights.model.AirplaneState
import com.endava.flights.model.Seat
import java.time.Instant
import java.time.LocalDateTime
import java.time.Period
import java.util.*

@RequiresApi(Build.VERSION_CODES.O)
class MockAirplaneRepository : AirplaneRepository {

    companion object {
        private val SEAT_1 = Seat("A1")
        private val SEAT_2 = Seat("A2")
        private val SEAT_3 = Seat("A3")
        private val SEAT_4 = Seat("A4")
        private val SEAT_5 = Seat("A5")
        private val SEAT_6 = Seat("A6")
        private val SEAT_7 = Seat("A7")
        private val SEAT_8 = Seat("A8")
        private val SEAT_9 = Seat("A9")
        private val SEAT_10 = Seat("B1")
        private val SEAT_11 = Seat("B2")
        private val SEAT_12 = Seat("B3")
        private val SEAT_13 = Seat("B4")
        private val SEAT_14 = Seat("B5")
        private val SEAT_15 = Seat("B6")
        private val SEAT_16 = Seat("B7")
        private val SEAT_17 = Seat("B8")
        private val SEAT_18 = Seat("B9")
        private val SEAT_19 = Seat("C1")
        private val SEAT_20 = Seat("C2")
        private val SEAT_21 = Seat("C3")
        private val SEAT_22 = Seat("C4")
        private val SEAT_23 = Seat("C5")
        private val SEAT_24 = Seat("C6")
        private val SEAT_25 = Seat("C7")
        private val SEAT_26 = Seat("C8")
        private val SEAT_27 = Seat("C9")

        private val SEATS = listOf(
            SEAT_1,
            SEAT_2,
            SEAT_3,
            SEAT_4,
            SEAT_5,
            SEAT_6,
            SEAT_7,
            SEAT_8,
            SEAT_9,
            SEAT_10,
            SEAT_11,
            SEAT_12,
            SEAT_13,
            SEAT_14,
            SEAT_15,
            SEAT_16,
            SEAT_17,
            SEAT_18,
            SEAT_19,
            SEAT_20,
            SEAT_21,
            SEAT_22,
            SEAT_23,
            SEAT_24,
            SEAT_25,
            SEAT_26,
            SEAT_27,
        )

        val AIRBUS_A350 = Airplane(
            1,
            AirplaneModel("Airbus A350-941"),
            AirplaneState.Available(
                LocalDateTime.now(),
                LocalDateTime.now().plusMonths(3)
            ),
            SEATS
        )

        val BOEING_787 = Airplane(
            2,
            AirplaneModel("Boeing 787-9 Dreamliner"),
            AirplaneState.Available(
                LocalDateTime.now(),
                LocalDateTime.now().plusMonths(3)
            ),
            SEATS
        )

        val AIRBUS_A330 = Airplane(
            3,
            AirplaneModel("Airbus A330-202"),
            AirplaneState.Available(
                LocalDateTime.now(),
                LocalDateTime.now().plusMonths(6)
            ),
            SEATS
        )

        val BOEING_737 = Airplane(
            3,
            AirplaneModel("Boeing 737-8EH"),
            AirplaneState.Available(
                LocalDateTime.now(),
                LocalDateTime.now().plusMonths(3)
            ),
            SEATS
        )

    }

    override suspend fun getAirplanes(): List<Airplane> {
        return listOf(AIRBUS_A350, BOEING_787, AIRBUS_A330, BOEING_737)
    }
}