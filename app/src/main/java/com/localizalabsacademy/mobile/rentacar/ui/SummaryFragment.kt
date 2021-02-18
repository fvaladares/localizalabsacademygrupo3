package com.localizalabsacademy.mobile.rentacar.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.localizalabsacademy.mobile.rentacar.databinding.FragmentSummaryBinding
import com.localizalabsacademy.mobile.rentacar.model.RentViewModel

class SummaryFragment : Fragment() {

    private val sharedViewModel: RentViewModel by activityViewModels()
    private var binding: FragmentSummaryBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        Log.w(TAG, "onCreateView")
        // Inflate the layout for this fragment

        val fragmentSummaryBinding = FragmentSummaryBinding.inflate(
            inflater,
            container,
            false
        )

        binding = fragmentSummaryBinding

        return fragmentSummaryBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Log.d(TAG, "onViewCreated")
        super.onViewCreated(view, savedInstanceState)
        binding?.apply {
            summaryFragment = this@SummaryFragment
            viewModel = sharedViewModel
            lifecycleOwner = viewLifecycleOwner
        }
    }


    companion object {

        const val TAG = "RENTSummaryFragment"

    }
}