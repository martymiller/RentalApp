package com.marty.rentalapp.di

import com.marty.rentalapp.network.NetworkService
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import org.koin.core.qualifier.named
import org.koin.dsl.module

val MAIN_SCHEDULER = named("MAIN_SCHEDULER")
val IO_SCHEDULER = named("IO_SCHEDULER")

val networkModule = module {
    single { NetworkService.initSearchApi() }
    single(MAIN_SCHEDULER) { AndroidSchedulers.mainThread() }
    single(IO_SCHEDULER) { Schedulers.io() }
}
