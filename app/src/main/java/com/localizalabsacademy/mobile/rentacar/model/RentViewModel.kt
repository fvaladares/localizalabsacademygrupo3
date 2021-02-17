package com.localizalabsacademy.mobile.rentacar.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.math.BigDecimal

class RentViewModel : ViewModel() {
    private val _pickupLocation = MutableLiveData<String>()
    val pickupLocation: LiveData<String> = _pickupLocation

    private val _returnLocation = MutableLiveData<String>()
    val returnLocation: LiveData<String> = _returnLocation

    private val _price = MutableLiveData<BigDecimal>()
    val price: LiveData<BigDecimal> = _price

    private val _vehicle = MutableLiveData<Vehicle>()
    var vehicle: LiveData<Vehicle> = _vehicle


    fun setPickupLocation(pickupLocation: String) {
        _pickupLocation.value = pickupLocation
    }

    fun setReturnLocation(returnLocation: String) {
        _returnLocation.value = returnLocation
    }

    fun setVehicle(vehicle: Vehicle) {
        _vehicle.value = vehicle
    }


}