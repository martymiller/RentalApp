package com.marty.rentalapp.ui.search

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.marty.rentalapp.network.NetworkServiceApi
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import org.koin.core.KoinComponent
import org.koin.core.inject

class SearchViewModel : ViewModel(), KoinComponent {

    val networkServiceApi: NetworkServiceApi by inject()
    val rentals = MutableLiveData<String>().apply { value = "" }

    fun fetchRentals(query: String) {
        //TODO
    }

    fun clearList(): Unit {
        //TODO
    }
}
