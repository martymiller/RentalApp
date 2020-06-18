package com.marty.rentalapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.marty.rentalapp.R
import com.marty.rentalapp.network.NetworkServiceApi
import org.koin.core.KoinComponent
import org.koin.core.context.KoinContextHandler.get
import org.koin.core.get
import org.koin.core.inject

class MainActivity : AppCompatActivity(), KoinComponent {

    private val serviceApi: NetworkServiceApi = get()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       // serviceApi.getRentals()
    }
}
