package com.localizalabsacademy.mobile.rentacar.model

import android.icu.math.BigDecimal

data class Vehicle(
    val id: String,
    val createdAt: String = "",
    val updatedAt: String = "",
    val plateLicense: String = "",
    val image: String = "",
    val nullable: Boolean = true,
    val year: Int,
    val fuelType: Int,
    val hourlyPrice: BigDecimal,
    val trunkCapacity: Int = 0,
    val tankCapacity: Int = 45,
    val vehicleModelId: String = "",
    val vehicleModel: String = ""
)
