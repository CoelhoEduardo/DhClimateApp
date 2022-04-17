package com.example.clima.views.viewHolder

import android.view.View

import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.clima.R
import com.example.clima.arquitetura.response.EventsItem



class SearchViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val location: TextView = view.findViewById(R.id.item_events_title)
    private val date: TextView = view.findViewById(R.id.date_events)

    fun bind(search: EventsItem) {
        location.text = search.title
        date.text = search.geometry?.date

    }
}
