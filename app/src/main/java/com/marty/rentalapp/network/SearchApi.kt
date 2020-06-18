package com.marty.rentalapp.network

import com.marty.rentalapp.model.search.SearchResults
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface SearchApi {

    companion object {
        private const val DEFAULT_PAGE_LIMIT: Int = 200
        private const val DEFAULT_PAGE_OFFSET: Int = 0
    }

    @GET("rentals")
    fun getRentals(
        @Query("filter[keywords]") keywords: String,
        @Query("page[limit]") pageLimit: Int = DEFAULT_PAGE_LIMIT,
        @Query("page[offset]") pageOffset: Int = DEFAULT_PAGE_OFFSET
    ): Single<SearchResults>
}
