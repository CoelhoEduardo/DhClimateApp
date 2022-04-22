package com.example.clima.views.viewHolder

import android.graphics.drawable.Drawable
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.clima.R
import com.example.clima.arquitetura.response.EventsItem


class SearchViewHolder(view: View) : RecyclerView.ViewHolder(view) {


    private val title: TextView = view.findViewById(R.id.item_events_title)
    private val date: TextView = view.findViewById(R.id.date_events)
    private val link: TextView = view.findViewById(R.id.link_events)
    private val eventsData: TextView = view.findViewById(R.id.data_events)
    private var eventPic: ImageView = view.findViewById(R.id.image)

    fun bind(search: EventsItem) {
        title.text = search.title
        date.text = search.geometry.first().date
        link.text = search.sources.first().url
        eventsData.text = search.categories.first().title
        eventPic.setImageResource(getImage(search.categories.first().title))
    }

}


fun getImage(text: String) : Int {
    if(text == "Volcanoes"){
        return R.drawable.ic_volcano_black_fundo
    }
    if(text == "Sea and Lake Ice"){
        return R.drawable.ic_ice_black_fundo
    }
    if(text == "Wildfires"){
        return R.drawable.ic_queimada_black_fundo
}
    if(text == "Landslides"){
        return R.drawable.ic_landslide_black_fundo
    }
    if(text == "Snow"){
        return R.drawable.ic_snow_black_fundo
    }
    if(text == "Floods"){
        return R.drawable.ic_flood_black_fundo
    }
    if(text == "Earthquakes"){
        return R.drawable.ic_earthquake_black_fundo
    }
    if(text == "Severe Storm"){
        return R.drawable.ic_storm_black_fundo
    }
    return 0
}


