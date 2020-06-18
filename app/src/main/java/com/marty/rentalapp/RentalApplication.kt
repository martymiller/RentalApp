package com.marty.rentalapp

import android.app.Application
import org.koin.android.ext.koin.androidContext

import com.marty.rentalapp.di.networkModule
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import timber.log.Timber

class RentalApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        initTimber()
        initKoin()
    }

    private fun initTimber() {
        if(BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

    private fun initKoin() {
        startKoin {
            androidLogger()
            androidContext(this@RentalApplication)
            modules(networkModule)
        }
    }
}
