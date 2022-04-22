package com.example.clima.views.viewHolder

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.clima.R
import com.example.clima.arquitetura.response.EventsItem


class SearchViewHolder(view: View) : RecyclerView.ViewHolder(view) {


    private val title: TextView = view.findViewById(R.id.item_events_title)
    private val date: TextView = view.findViewById(R.id.date_events)
    private val link: TextView = view.findViewById(R.id.link_events)
    private val eventsData: TextView = view.findViewById(R.id.data_events)

    fun bind(search: EventsItem) {
        title.text = search.title
        date.text = search.geometry.first().date
        link.text = search.categories.first().title
        eventsData.text = search.sources.first().url
    }

}
