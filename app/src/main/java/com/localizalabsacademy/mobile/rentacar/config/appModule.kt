package com.localizalabsacademy.mobile.rentacar.config

import com.localizalabsacademy.mobile.rentacar.model.RentViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { RentViewModel() }
}