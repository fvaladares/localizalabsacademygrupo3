package com.localizalabsacademy.mobile.rentacar.model

import android.content.res.Resources
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.localizalabsacademy.mobile.rentacar.R
import com.localizalabsacademy.mobile.rentacar.util.HourSource
import java.math.BigDecimal
import java.util.*

class RentViewModel : ViewModel() {
    private val _pickupLocation = MutableLiveData<String>()
    val pickupLocation: LiveData<String> = _pickupLocation

    private val _returnLocation = MutableLiveData<String>()
    val returnLocation: LiveData<String> = _returnLocation

    private val _price = MutableLiveData<BigDecimal>()
    val price: LiveData<BigDecimal> = _price

    private val _vehicle = MutableLiveData<Vehicle>()
    var vehicle: LiveData<Vehicle> = _vehicle

    private val _questionLocation = MutableLiveData<String>()
    val questionLocation: LiveData<String> = _questionLocation


    private fun setPickupLocation(pickupLocation: String) {
        _pickupLocation.value = pickupLocation
    }

    private fun setReturnLocation(returnLocation: String) {
        _returnLocation.value = returnLocation
    }

    fun setLocation() {
        val stringTest = Resources.getSystem()
            .getString(R.string.pickup_label)
        if (questionLocation.value
                .toString().equals(stringTest)
        ) {
            if (!pickupLocation.value.isNullOrBlank()) {
                _returnLocation.value = ""
            }
            setPickupLocation("location")

        } else {
            setReturnLocation("location")
        }
    }


    fun getLocation(): String = when (questionLocation.value) {
        Resources.getSystem().getString(R.string.pickup_label) ->
            pickupLocation.toString()
        else ->
            returnLocation.toString()
    }

//        if (questionLocation.value
//                .equals(
//                    Resources.getSystem()
//                        .getString(R.string.pickup_label),
//                )
//        ) {
//            pickupLocation
//
//        } else {
//            returnLocation
//        }
//    }

    fun setLocationQuestion(questionLocation: String) {
        _questionLocation.value = questionLocation
    }

    fun setVehicle(vehicle: Vehicle) {
        _vehicle.value = vehicle
    }

    fun getDataSet(): List<Date> = HourSource().getHours()


}