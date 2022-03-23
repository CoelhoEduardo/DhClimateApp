package com.example.clima.Model.Maps

import android.widget.ListView

data class EventsResponse (val events: List<EventsItem>)

data class EventsItem(val id: String, val title: String, val link: String, val categories: CategoriesEvents, val sources: SourcesEvent, val geometry: GeometryEvent)

data class CategoriesEvents(val categoriesId: String, val categoriesTitle: String)

data class SourcesEvent(val id: String, val url: String)

data class GeometryEvent(val magnitudeValue: Float, val magnitudeUnit: String, val date: String, val Type: String, val coordinates: ListView)
