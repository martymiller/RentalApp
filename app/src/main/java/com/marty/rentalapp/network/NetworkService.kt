package com.marty.rentalapp.network

import com.marty.rentalapp.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
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

        fun init(): NetworkServiceApi =
            Retrofit.Builder()
                .baseUrl("https://api.coinbase.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(client)
                .build()
                .create(NetworkServiceApi::class.java)
    }
}
