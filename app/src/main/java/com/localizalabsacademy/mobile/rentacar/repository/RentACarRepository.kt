package com.localizalabsacademy.mobile.rentacar.repository

interface RentACarRepository {
    suspend fun searchAgencies(query: String)
}