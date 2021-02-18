package com.localizalabsacademy.mobile.rentacar.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnFocusChangeListener
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.localizalabsacademy.mobile.rentacar.R
import com.localizalabsacademy.mobile.rentacar.databinding.FragmentStartBinding

import com.localizalabsacademy.mobile.rentacar.model.RentViewModel


class StartFragment : Fragment() {
    // Binding object instance corresponding to the fragment_start.xml layout
    // This property is non-null between the onCreateView() and onDestroyView() lifecycle callbacks,
    // when the view hierarchy is attached to the fragment.
    private var binding: FragmentStartBinding? = null
    private val sharedViewModel: RentViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        Log.d(TAG, "onCreteView")
        val fragmentBinding = FragmentStartBinding.inflate(
            inflater,
            container,
            false
        )
        binding = fragmentBinding

        /**
         * Call the SelectAgencyFragment on touch
         */
        binding?.startTietPickupAgency?.onFocusChangeListener =
            OnFocusChangeListener { _, hasFocus ->
                if (hasFocus) {
                    sharedViewModel.setLocationQuestion(getString(R.string.pickup_label))
                    goToLocationScreen()
                }
            }


        binding?.startTietReturnAgency?.onFocusChangeListener =
            OnFocusChangeListener { _, hasFocus ->
                if (hasFocus) {
                    sharedViewModel.setLocationQuestion(getString(R.string.return_label))
                    goToLocationScreen()
                }
            }

        return fragmentBinding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(TAG, "onViewCreated")
        binding?.apply {
            startFragment = this@StartFragment
            viewModel = sharedViewModel
            lifecycleOwner = viewLifecycleOwner
        }
    }

    /**
     * Navigate to the next screen to choose pickup location.
     */
    fun goToLocationScreen() {
        Log.d(TAG, "goToLocationScreen()")
        findNavController().navigate(R.id.action_startFragment_to_selectAgencyFragment)
    }


    /**
     * Navigate to the next screen to choose pickup date.
     */
    fun goToCalendarScreen() {
        Log.d(TAG, "goToCalendarScreen()")
        findNavController().navigate(R.id.action_startFragment_to_selectDateFragment)
    }


    fun goToMyReservationScreen() {
        Log.d(TAG, "goToMyReservationScreen()")
        findNavController().navigate(R.id.action_startFragment_to_reservationsFragment)
    }

    fun goToSummaryScreen() {
        Log.d(TAG, "goToSummaryScreen")
        findNavController().navigate(R.id.action_startFragment_to_summaryFragment)
    }


    /**
     * This fragment lifecycle method is called when the view hierarchy associated with the fragment
     * is being removed. As a result, clear out the binding object.
     */
    override fun onDestroyView() {
        super.onDestroyView()
        Log.d(TAG, "onDestroy")
        binding = null
    }


    companion object {
        private const val TAG = "RENTStartFragment"
    }
}