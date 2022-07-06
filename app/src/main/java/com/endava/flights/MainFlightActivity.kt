package com.endava.flights

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.FragmentActivity
import com.endava.flights.viewmodel.RouteViewModel

/**
 *
 * Using at least in one case coroutines and in one case flows.
 * Generate the unit test for each case.
 *
 * 1. Get all Buenos Aires departure air routes
 * 2. Get the cheapest route.
 * 3. Return the flight codes with at least tourist and business class.
 * 4. Make a purchase in the emptier Flight in Business or a better one class.
 * 5. Print the boarding pass Ticket for the last purchase. (bar code with main data is a plus)
 *
 * Bonus track: Think one use case as a challenge for your partner.
 *
 */
class MainFlightActivity : FragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        val viewModel = RouteViewModel()
        viewModel.bsAsRoutesLD.observe(this) {
            it?.forEach {airRoute ->
                Log.i("BsAsRoutes", "${airRoute.from} -> ${airRoute.to}")
            }
        }
        viewModel.fetchBsAsRoutes()
        super.onCreate(savedInstanceState)
    }

}