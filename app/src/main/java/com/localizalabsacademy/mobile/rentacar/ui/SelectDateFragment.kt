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


class SelectDateFragment : Fragment() {

    private var binding: FragmentSelectDateBinding? = null
    private val sharedViewModel: RentViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
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
        }
    }


    fun cancelAction() {
        /**
         * Destroy the fragment and return to [StartFragment]
         */

        findNavController().navigate(R.id.action_selectDateFragment_to_startFragment)
        Toast.makeText(context, "Cancel button clicked", Toast.LENGTH_SHORT).show()
        Log.d(TAG, "Cancel Action activated")
    }

    fun okButtonAction() {
        findNavController().navigate(R.id.action_selectDateFragment_to_selectHourFragment)
        Toast.makeText(context, "Okay button clicked", Toast.LENGTH_SHORT).show()
        Log.d(TAG, "Okay Action activated")
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