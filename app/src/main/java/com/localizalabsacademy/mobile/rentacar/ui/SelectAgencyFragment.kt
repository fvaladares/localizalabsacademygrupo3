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
import com.localizalabsacademy.mobile.rentacar.databinding.FragmentSelectAgencyBinding
import com.localizalabsacademy.mobile.rentacar.model.RentViewModel


class SelectAgencyFragment : Fragment() {

    private var binding: FragmentSelectAgencyBinding? = null

    //    private val sharedViewModel: RentViewModel by viewModel()
    private val sharedViewModel: RentViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
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
            lifecycleOwner = viewLifecycleOwner
//            selectBtnAgencyOk.setOnClickListener {
//                sharedViewModel.setLocation(selectAgencyEtAgencyName.text.toString())
//                Toast.makeText(context, "Botao acionado", Toast.LENGTH_SHORT).show()
//            }
        }
    }

    /**
     * Navigate back to [StartFragment]
     */
    fun returnStartFragment() {
        sharedViewModel.setLocation(binding!!.selectAgencyEtAgencyName.text.toString())
        Toast.makeText(context, "Botao acionado", Toast.LENGTH_SHORT).show()
        findNavController().navigate(R.id.action_selectAgencyFragment_to_startFragment)
    }

//
//    fun setAgencyLocation(location: String) {
//        sharedViewModel.setLocation(location)
//    }

    companion object {
        const val TAG = "RENTSelectAgency"
    }
}