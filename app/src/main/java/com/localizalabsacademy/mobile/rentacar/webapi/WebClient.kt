package com.localizalabsacademy.mobile.rentacar.webapi

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class WebClient {

    private val retrofit = Retrofit.Builder().baseUrl(endPointUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .build()


    companion object {

        fun getRetrofitInstance(url: String): Retrofit {
            return Retrofit.Builder().baseUrl(endPointUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        private const val endPointUrl = "http://52.188.27.221:5000"
    }
}