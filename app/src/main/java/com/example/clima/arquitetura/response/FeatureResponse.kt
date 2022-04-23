package com.example.clima.arquitetura.response

import java.security.Key


data class FeatureResponse(
    val type: String,
    val features: List<FeatureType>,
)

data class FeatureType(
    val type: String,
    val properties: FeatureItem,
    val geometry: GeometryFeatureItem
)

data class FeatureItem(
    val id: String,
    val title: String,
    val link: String,
    val date: String,
    val categories: List<CategoriesFeatureItem>,
    val sources: List<SourcesFeatureItem>,

    )

data class GeometryFeatureItem(

    val type: String,
    val coordinates: List<Double>

)

data class CategoriesFeatureItem(val id: String, val title: String)
data class SourcesFeatureItem(val id: String, val url: String)


