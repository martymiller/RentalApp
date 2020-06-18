package com.marty.rentalapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.marty.rentalapp.R
import com.marty.rentalapp.network.SearchApi
import org.koin.core.KoinComponent
import org.koin.core.get

class MainActivity : AppCompatActivity(), KoinComponent {

    private val serviceSearchApi: SearchApi = get()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       // serviceApi.getRentals()
    }
}
