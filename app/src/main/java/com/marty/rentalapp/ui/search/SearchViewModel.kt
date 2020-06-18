package com.marty.rentalapp.ui.search

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.marty.rentalapp.model.search.SearchResults
import com.marty.rentalapp.di.IO_SCHEDULER
import com.marty.rentalapp.di.MAIN_SCHEDULER
import com.marty.rentalapp.model.search.SearchItem
import com.marty.rentalapp.model.search.toSearchItemsList
import com.marty.rentalapp.network.SearchApi
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.disposables.CompositeDisposable
import org.koin.core.KoinComponent
import org.koin.core.get
import timber.log.Timber

class SearchViewModel : ViewModel(), KoinComponent {

    private val searchApi: SearchApi = get()
    private val mainScheduler: Scheduler = get(MAIN_SCHEDULER)
    private val ioScheduler: Scheduler = get(IO_SCHEDULER)
    private val compositeDisposable = CompositeDisposable()
    internal val rentals = MutableLiveData<List<SearchItem>>()
    internal val showError = MutableLiveData<Boolean>().apply { value = false }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }

    fun fetchRentals(query: String) {
        searchApi.getRentals(query)
            .subscribeOn(ioScheduler)
            .observeOn(mainScheduler)
            .also { Timber.d("searching for $query") }
            .doOnSuccess { showError.postValue(false) }
            .map(SearchResults::toSearchItemsList)
            .subscribe(rentals::postValue) { throwable ->
                Timber.e(throwable, "Unable to fetch rentals")
            }
            .let(compositeDisposable::add)
    }

    fun clearList(): Unit {
        //TODO
    }
}
