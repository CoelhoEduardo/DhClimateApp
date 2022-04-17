package com.example.clima.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.clima.R
import com.example.clima.arquitetura.response.EventsItem
import com.example.clima.arquitetura.response.EventsResponse
import com.example.clima.views.viewHolder.SearchViewHolder

private const val HEADER = 0
private const val CONTENT = 1
private const val FOOTER = 2


//val mysearch: MutableList<Search> = mutableListOf()

class SearchAdapter: RecyclerView.Adapter<SearchViewHolder>() {
    private val search: MutableList<EventsItem> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return SearchViewHolder(inflater.inflate(R.layout.item_search, parent, false))

    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
             holder.bind(search[position])
        }


    override fun getItemCount() = search.size

    fun updateList(eventList: EventsItem){
        search.add(eventList)
        notifyDataSetChanged()

    }

}



