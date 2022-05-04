package com.example.clima.arquitetura.local.entity


import androidx.room.*
import com.example.clima.arquitetura.response.CategoriesItem
import com.example.clima.arquitetura.response.GeometryItem
import com.example.clima.arquitetura.response.SourcesItem
import com.google.gson.Gson

@Entity(tableName = "events")
data class EventsEntity(
    @PrimaryKey
    var id: String,

    @ColumnInfo
    val title: String,

    @ColumnInfo
    val link: String,

    @ColumnInfo
    val categoriesItem: List<CategoriesItem>,

    @ColumnInfo
    val sourcesItem: List<SourcesItem>,

    @ColumnInfo
    val geometryItem: List<GeometryItem>,

    )

class Converter{
    @TypeConverter
    fun listToString(value: List<CategoriesItem>?): String = Gson().toJson(value)

    @TypeConverter
    fun jsonStringToList(value: String) = Gson().fromJson(value, Array<CategoriesItem>::class.java)!!

    @TypeConverter
    fun listToStringSources(value: List<SourcesItem>?): String = Gson().toJson(value)

    @TypeConverter
    fun jsonStringToListSources(value: String) = Gson().fromJson(value, Array<SourcesItem>::class.java)!!

    @TypeConverter
    fun listToStringGeometry(value: List<GeometryItem>?): String = Gson().toJson(value)

    @TypeConverter
    fun jsonStringToListGeometry(value: String) = Gson().fromJson(value, Array<GeometryItem>::class.java)!!

}