package com.localizalabsacademy.mobile.rentacar.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.localizalabsacademy.mobile.rentacar.R
import com.localizalabsacademy.mobile.rentacar.adapter.ItemHourAdapter
import com.localizalabsacademy.mobile.rentacar.databinding.FragmentSelectHourBinding
import com.localizalabsacademy.mobile.rentacar.util.HourSource


/**
 * A simple [Fragment] subclass.
 * Use the [SelectHourFragment.newInstance] factory method to
 * create an instance of this fragment.
 */


class SelectHourFragment : Fragment() {

    private var binding: FragmentSelectHourBinding? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        Log.d(TAG, "onCreateView")
        val fragmentBinding = FragmentSelectHourBinding.inflate(
            inflater,
            container,
            false
        )
        binding = fragmentBinding

        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.selectHourFragment = this

        val myDataSet = HourSource().getHours()

        val layoutManager = LinearLayoutManager(context)

        binding?.selectHourRecyclerView?.apply {
            adapter =
                ItemHourAdapter(context, myDataSet)
            this.layoutManager = layoutManager
            setHasFixedSize(true)
        }
    }

    fun pickHour() {
        findNavController().navigate(R.id.action_selectHourFragment_to_startFragment)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    companion object {
        const val TAG: String = "SelectHourFragment"
    }


}