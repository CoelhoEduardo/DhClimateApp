package com.example.clima.arquitetura.response


data class EventsResponse(
    val title: String,
    val link: String,
    val description: String,
    val events: List<EventsItem>,
)

data class EventsItem(
    val id: String,
    val title: String,
    val link: String,
    val categories: List<CategoriesItem>,
    val sources: List<SourcesItem>,
    val geometry: List<GeometryItem>
)

data class GeometryItem(
    val magnitudeValue: Double,
    val magnitudeUnit: String,
    val date: String,
    val type: String,
    val coordinates: List<Double>
)

data class CategoriesItem(val id: String, val title: String)
data class SourcesItem(val id: String, val url: String)