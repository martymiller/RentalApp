package com.marty.rentalapp.model.search

import timber.log.Timber

fun SearchResults.toSearchItemsList(): List<SearchItem> {
    val includedMap: Map<String, String>? = included?.associateBy({ it.id }, { it.attributes.imageUrl })
    return data.map {
        SearchItem(
            it.id.toInt(),
            it.attributes.name,
            it.relationships.primaryImage?.data?.id.let { imageUrl -> includedMap?.get(imageUrl) }
        )
    }
}
