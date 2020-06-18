package com.marty.rentalapp.ui.search

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.jakewharton.rxbinding4.view.clicks
import com.jakewharton.rxrelay3.PublishRelay
import com.marty.rentalapp.R
import com.marty.rentalapp.model.search.SearchItem
import com.squareup.picasso.Picasso
import io.reactivex.rxjava3.core.Observable

internal class SearchAdapter : RecyclerView.Adapter<SearchAdapter.SearchViewHolder>() {

    private val searchItemsList = mutableListOf<SearchItem>()

    init {
        setHasStableIds(true)
    }

    internal class SearchViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val image: ImageView = view.findViewById(R.id.searchImage)
        val title: TextView = view.findViewById(R.id.searchTitle)
    }

    override fun getItemCount() = searchItemsList.size

    override fun getItemId(position: Int): Long = searchItemsList[position].id.toLong()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder =
        SearchViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.search_adapter_item, parent, false))

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        searchItemsList[position].apply {
            holder.title.text = title
            Picasso.get().load(imageUrl).into(holder.image)
        }
        holder.itemView.clicks().subscribe {
            onItemClicked.accept(searchItemsList[position])
        }
    }

    fun onItemClicked(): Observable<SearchItem> = onItemClicked
    private val onItemClicked = PublishRelay.create<SearchItem>()

    fun update(updatedList: List<SearchItem>) {
        searchItemsList.clear()
        searchItemsList.addAll(updatedList)
        notifyDataSetChanged()
    }
}
