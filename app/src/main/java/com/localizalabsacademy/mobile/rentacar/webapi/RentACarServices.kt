package com.localizalabsacademy.mobile.rentacar.webapi

import retrofit2.http.GET

interface RentACarServices {
    @GET("api/Agency")
    suspend fun getAllAgencies()
}