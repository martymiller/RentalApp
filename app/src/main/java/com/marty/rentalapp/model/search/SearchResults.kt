package com.marty.rentalapp.model.search

import com.google.gson.annotations.SerializedName

class SearchResults(
    val data: List<DataItem>,
    val included: List<IncludedItem>
) {

    //Find primary image URL of rental by getting the ID from `data[].relationships.primary_image.data.id`
    //and finding the matching `id` with `type: images` from the `included` array. The image URL is at `included[].attributes.url`.

    class DataItem(
        @SerializedName("id") val id: String,
        @SerializedName("attributes") val attributes: Attributes,
        @SerializedName("relationships") val relationships: Relationships
    ) {
        class Attributes(
            @SerializedName("name") val name: String
        )

        class Relationships(
            @SerializedName("primary_image") val primaryImage: PrimaryImage?
        ) {
            class PrimaryImage(
                @SerializedName("data") val data: Data
            )

            class Data(
                @SerializedName("id") val id: String,
                @SerializedName("type") val type: String
            )
        }
    }

    class IncludedItem(
        @SerializedName("attributes") val attributes: Attributes,
        @SerializedName("id") val id: String
    ) {
        class Attributes(
            @SerializedName("url") val imageUrl: String
        )
    }
}
