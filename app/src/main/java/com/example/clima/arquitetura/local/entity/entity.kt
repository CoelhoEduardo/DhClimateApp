package com.example.clima.arquitetura.local.entity


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import com.example.clima.arquitetura.response.CategoriesItem
import com.example.clima.arquitetura.response.GeometryItem
import com.example.clima.arquitetura.response.SourcesItem
import com.google.gson.Gson

@Entity(tableName = "events")
data class EventsEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,

    @ColumnInfo
    val idApi: String,

    @ColumnInfo
    val title: String,

    @ColumnInfo
    val link: String,

    @ColumnInfo()
    val categories: String,

    @ColumnInfo()
    val sources: String,

    @ColumnInfo()
    val geometryItem: String,

    )
class Converters{

    @TypeConverter
    fun listToStringCategories(value: List<CategoriesItem>): String {
        return Gson().toJson(value)
    }

    @TypeConverter
    fun stringToListCategories(value: String): Array<CategoriesItem> {
        return Gson().fromJson(value, Array<CategoriesItem>::class.java)!!
    }

    @TypeConverter
    fun listToStringSources(value: List<SourcesItem>): String {
        return Gson().toJson(value)
    }

    @TypeConverter
    fun stringToListSources(value: String): Array<SourcesItem> {
        return Gson().fromJson(value, Array<SourcesItem>::class.java)!!
    }

    @TypeConverter
    fun listToStringGeometry(value: List<GeometryItem>): String {
        return Gson().toJson(value)
    }

    @TypeConverter
    fun stringToListGeometry(value: String): Array<GeometryItem> {
        return Gson().fromJson(value, Array<GeometryItem>::class.java)!!
    }

}
