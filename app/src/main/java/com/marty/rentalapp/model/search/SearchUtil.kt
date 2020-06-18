package com.marty.rentalapp.model.search

import timber.log.Timber

fun SearchResults.toSearchItemsList(): List<SearchItem> {
    val includedMap: Map<String, String> = included.associateBy({ it.id }, { it.attributes.imageUrl })
    return data.map {
        Timber.d("adding ${it.id} with url ${includedMap[it.relationships.primaryImage?.data?.id]}")
        SearchItem(
            it.id.toInt(),
            it.attributes.name,
            includedMap[it.relationships.primaryImage?.data?.id]
        )
    }
}
