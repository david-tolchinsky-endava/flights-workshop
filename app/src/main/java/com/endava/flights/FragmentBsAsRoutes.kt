package com.endava.flights

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.endava.flights.databinding.FragmentBsasRouteBinding

class FragmentBsAsRoutes : Fragment() {

    var binding: FragmentBsasRouteBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBsasRouteBinding.inflate(inflater, container, false)

        return binding?.root
    }

}