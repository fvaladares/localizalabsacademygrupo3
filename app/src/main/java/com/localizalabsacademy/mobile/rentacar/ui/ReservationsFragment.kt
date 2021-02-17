package com.localizalabsacademy.mobile.rentacar.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.localizalabsacademy.mobile.rentacar.databinding.FragmentReservationsBinding
import com.localizalabsacademy.mobile.rentacar.model.RentViewModel


class ReservationsFragment : Fragment() {

    private var binding: FragmentReservationsBinding? = null
    private val sharedViewModel: RentViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        Log.d(TAG, "onCreteView")

        // Inflate the layout for this fragment
        val fragmentReservationsBinding = FragmentReservationsBinding.inflate(
            inflater,
            container,
            false
        )

        binding = fragmentReservationsBinding

        return fragmentReservationsBinding.root
    }

    companion object {
        const val TAG = "RENTReservationFragment"
    }
}