package com.localizalabsacademy.mobile.rentacar

import android.app.Application
import com.localizalabsacademy.mobile.rentacar.config.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class RentACar : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@RentACar)
            modules(appModule)
        }
    }
}