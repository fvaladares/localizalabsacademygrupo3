package com.localizalabsacademy.mobile.rentacar.model

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.localizalabsacademy.mobile.rentacar.util.HourSource
import kotlinx.coroutines.launch
import java.math.BigDecimal
import java.util.*

class RentViewModel : ViewModel() {
    private val _pickupLocation =
        MutableLiveData<String>()
    val pickupLocation: LiveData<String> =
        _pickupLocation

    private val _returnLocation =
        MutableLiveData<String>()
    val returnLocation: LiveData<String> =
        _returnLocation

    private val _pickupDateHour =
        MutableLiveData(Date(0L))
    val pickupDateHour: LiveData<Date> =
        _pickupDateHour

    private val _returnDateHour =
        MutableLiveData(Date(0L))
    val returnDateHour: LiveData<Date> =
        _returnDateHour

    private val _price =
        MutableLiveData<BigDecimal>()
    val price: LiveData<BigDecimal> =
        _price

    private val _vehicle =
        MutableLiveData<Vehicle>()
    var vehicle: LiveData<Vehicle> =
        _vehicle

    private val _questionLocation =
        MutableLiveData<String>()
    val questionLocation: LiveData<String> =
        _questionLocation

    private var _pickupEqualsToReturn =
        MutableLiveData(true)
    val pickupEqualsToReturn: LiveData<Boolean> =
        _pickupEqualsToReturn

    private val _hourDataSource =
        MutableLiveData<List<Date>>()
    private val hourDataSource: LiveData<List<Date>> =
        _hourDataSource

    private var _isPickup = true
    var isPickup = _isPickup


    private fun setPickupLocation(pickupLocation: String) {
        _pickupLocation.value = pickupLocation
    }

    private fun setReturnLocation(returnLocation: String) {
        _returnLocation.value = returnLocation
    }

    fun setPickupEqualsToReturn() {
        _pickupEqualsToReturn.value = !_pickupEqualsToReturn.value!!
    }

    fun setHour(time: Long) {
        Log.w("FGV_RentViewModel", time.toString())


        if (isPickup) {
            setPickupDateHour(time)
        } else {
            setReturnDateHour(time)
        }
    }


    private fun setPickupDateHour(time: Long) {
        _pickupDateHour.value = HourSource.convertToDate(time)
        Log.w("VIEWMODEL", pickupDateHour.value.toString())
    }

    private fun setReturnDateHour(time: Long) {
        if (time != 0L) {
            _returnDateHour.value = HourSource.convertToDate(time)
        } else {
            _returnDateHour.value = HourSource.convertToDate(0)
        }

        Log.w("VIEWMODEL", pickupDateHour.value.toString())
    }

    fun setLocation(location: String) {
        if (isPickup) {
            if (!pickupLocation.value.isNullOrBlank()) {
                _returnLocation.value = location
            }
            setPickupLocation(location)
            if (pickupEqualsToReturn.value == true) {
                setReturnLocation(location)
            } else {
                setReturnLocation(location)
            }
        }


//        val stringTest = "Where do you want to pick-up your car?"
//        if (questionLocation.value
//                .toString().equals(stringTest)
//        ) {
//            if (!pickupLocation.value.isNullOrBlank()) {
//                _returnLocation.value = location
//            }
//            setPickupLocation(location)
//            if (pickupEqualsToReturn.value == true) {
//                setReturnLocation(location)
//            }
//
//        } else {
//            setReturnLocation(location)
//        }
    }


    fun getLocation(): String = if (isPickup) {
        when (pickupLocation.value) {
            null -> ""
            else -> pickupLocation.value.toString()
        }
    } else {
        when (returnLocation.value) {
            null -> ""
            else -> returnLocation.value.toString()
        }
    }


//        when (questionLocation.value) {
//
//        "Where do you want to pick-up your car?" ->
//
//            when (pickupLocation.value) {
//                null -> ""
//                else -> pickupLocation.value.toString()
//            }
//        "Where do you want to return your car?" ->
//            when (returnLocation.value) {
//                null -> ""
//                else -> returnLocation.value.toString()
//            }
//        else -> ""
//    }


    fun setLocationQuestion(questionLocation: String) {
        _questionLocation.value = questionLocation
    }

    fun setVehicle(vehicle: Vehicle) {
        _vehicle.value = vehicle
    }

    /**
     * This function returns a [List<Date>] of the possible pickup or return hour
     */
    fun getHourDataSet(): List<Date> {

        _hourDataSource.value = if (isPickup)
            HourSource.getHours(pickupDateHour.value!!)
        else
            HourSource.getHours(returnDateHour.value!!)
        Log.w("FGV", _hourDataSource.value!!.toString())
        return hourDataSource.value!!
    }

    fun setHourForPickupOrReturn(position: Int) {
        if (isPickup) {
            _pickupDateHour.value = _hourDataSource.value!![position]
        } else {
            _returnDateHour.value = _hourDataSource.value!![position]
        }
    }

    fun getToday(): Long = HourSource.getTime()

    fun changePickup(isPickup: Boolean) {
        this.isPickup = isPickup
    }


    fun searchAgenciesWS(query: String) {
        viewModelScope.launch {
            Log.d(
                "RENT_ViewModel",
                "Searching for agencies at the web server"
            )

//            val response = itemRepository.search(query)


            Log.d(
                "RENT_ViewModel",
                "End of method >> Searching for agencies at the web server"
            )
        }
    }

}