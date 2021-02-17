package com.localizalabsacademy.mobile.rentacar.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.localizalabsacademy.mobile.rentacar.databinding.FragmentSelectAgencyBinding
import com.localizalabsacademy.mobile.rentacar.model.RentViewModel


class SelectAgencyFragment : Fragment() {

    private var binding: FragmentSelectAgencyBinding? = null
    private val sharedViewModel: RentViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        Log.d(TAG, "onCreateView()")
        val fragmentBinding = FragmentSelectAgencyBinding.inflate(
            inflater,
            container,
            false
        )

        binding = fragmentBinding
        // Inflate the layout for this fragment
        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(TAG, "onViewCreated")
        binding?.apply {
            selectAgencyFragment = this@SelectAgencyFragment
            viewModel = sharedViewModel
        }
    }


    fun setAgencyLocation() {
        sharedViewModel.setLocation("Test")
    }

    companion object {
        const val TAG = "RENTSelectAgency"
    }
}