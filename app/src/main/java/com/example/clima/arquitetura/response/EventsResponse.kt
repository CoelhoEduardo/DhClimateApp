package com.example.clima.arquitetura.response

import com.example.clima.arquitetura.local.entity.EventsEntity


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
) {
    constructor(entity: EventsEntity): this(
        entity.id,
        entity.title,
        entity.link,
        entity.categoriesItem,
        entity.sourcesItem,
        entity.geometryItem
    )
}

fun EventsItem.toEventsEntity() = EventsEntity(
    id = id,
    title = title,
    link = link,
    categoriesItem = categories,
    sourcesItem = sources,
    geometryItem = geometry,
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