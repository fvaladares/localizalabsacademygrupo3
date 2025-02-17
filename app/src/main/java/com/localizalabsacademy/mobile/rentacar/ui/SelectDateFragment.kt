package com.localizalabsacademy.mobile.rentacar.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.localizalabsacademy.mobile.rentacar.R
import com.localizalabsacademy.mobile.rentacar.databinding.FragmentSelectDateBinding
import com.localizalabsacademy.mobile.rentacar.model.RentViewModel
import java.util.*


class SelectDateFragment : Fragment() {

    private var binding: FragmentSelectDateBinding? = null
    private val sharedViewModel: RentViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        // Inflate the layout for this fragment
        val fragmentBinding = FragmentSelectDateBinding.inflate(
            inflater,
            container,
            false
        )

        binding = fragmentBinding
        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.apply {
            selectDateFragment = this@SelectDateFragment
            viewModel = sharedViewModel
            lifecycleOwner = viewLifecycleOwner
            dateCalendar.setOnDateChangeListener { view, year, month, dayOfMonth ->
                Log.d("FGV>>>", "$year/$month/$dayOfMonth")
                val c = Calendar.getInstance()
                c.set(year, month, dayOfMonth)
                Log.d("FGV>>>", "c.time ${c.time}")
                sharedViewModel.setHour(c.timeInMillis)
                view.date = c.timeInMillis
                Log.d("FGV>>>",
                    "sharedViewModel.getHourDataSet() ${sharedViewModel.getHourDataSet()}")
                Log.d("FGV>>>",
                    "sharedViewModel.pickupDateHour.value ${sharedViewModel.pickupDateHour.value}")
                Log.d("FGV>>>",
                    "sharedViewModel.returnDateHour.value ${sharedViewModel.returnDateHour.value}")
            }
        }
    }


    fun okButtonAction() {
        Log.d("FGV>>>", "Starting onButtonAction")

        // Used to generate the Hour data set
        sharedViewModel.setHour(binding!!.dateCalendar.date)

        setDateRouteTitleAndNavigate()
    }


    fun cancelAction() {
        /**
         * Destroy the fragment and return to [StartFragment]
         */

        findNavController().navigate(R.id.action_selectDateFragment_to_startFragment)
        Toast.makeText(context, "Cancel button clicked", Toast.LENGTH_SHORT).show()
        Log.d(TAG, "Cancel Action activated")
    }

    fun setMinDate(): Long =
        if
                (sharedViewModel.isPickup) sharedViewModel.getToday()
        else
            sharedViewModel.pickupDateHour.value!!.time


    private fun setDateRouteTitleAndNavigate() {
        if (sharedViewModel.isPickup) {
            val action = SelectDateFragmentDirections
                .actionSelectDateFragmentToSelectHourFragment(
                    getString(R.string.pickup_hour),
                )
            findNavController().navigate(action)
        } else {
            val action = SelectDateFragmentDirections
                .actionSelectDateFragmentToSelectHourFragment(
                    getString(R.string.return_hour),
                )
            findNavController().navigate(action)
        }

    }


    /**
     * This fragment lifecycle method is called when the view hierarchy associated with the fragment
     * is being removed. As a result, clear out the binding object.
     */
    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    companion object {
        private const val TAG = "SelectDateFragment"

        @JvmStatic
        fun newInstance() =
            SelectDateFragment()
    }
}