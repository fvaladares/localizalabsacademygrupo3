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

    private val _totalCost = MutableLiveData<BigDecimal>()
    val totalCost: LiveData<BigDecimal> = _totalCost

    private val _vehicle = MutableLiveData<Vehicle>()
    val vehicle: LiveData<Vehicle> = _vehicle

    private val _totalBill = MutableLiveData<BigDecimal>()
    val totalBill: LiveData<BigDecimal> = _totalBill


}