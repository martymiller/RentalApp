package com.marty.rentalapp.network

import com.marty.rentalapp.BuildConfig
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NetworkService {

    companion object {

        private val client: OkHttpClient by lazy {
            val clientBuilder = OkHttpClient.Builder()
            if (BuildConfig.BUILD_TYPE == "debug") {
                val loggingInterceptor = HttpLoggingInterceptor().apply {
                    level = HttpLoggingInterceptor.Level.BODY
                }
                clientBuilder.addInterceptor(loggingInterceptor)
            }
            return@lazy clientBuilder.build()
        }

        fun initSearchApi(): SearchApi =
            Retrofit.Builder()
                .baseUrl("https://search.outdoorsy.co/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .client(client)
                .build()
                .create(SearchApi::class.java)
    }
}
