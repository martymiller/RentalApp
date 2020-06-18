package com.marty.rentalapp.network

import io.reactivex.Observable
import retrofit2.http.GET

interface NetworkServiceApi {

    @GET("/getstfuff")
    fun getRentals() = 1// Observable<Any>
}
