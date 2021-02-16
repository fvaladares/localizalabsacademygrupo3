package com.localizalabsacademy.mobile.rentacar.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.localizalabsacademy.mobile.rentacar.R
import com.localizalabsacademy.mobile.rentacar.databinding.FragmentSelectDateBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
private const val TAG = "SelectDateFragment"

/**
 * A simple [Fragment] subclass.
 * Use the [SelectDateFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SelectDateFragment : Fragment() {

    private var binding: FragmentSelectDateBinding? = null

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

        binding?.selectDateFragment = this
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

        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment SelectDateFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SelectDateFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}