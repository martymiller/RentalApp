package com.marty.rentalapp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.marty.rentalapp.R
import org.koin.core.KoinComponent

class MainActivity : AppCompatActivity(), KoinComponent {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
