package com.example.clima.arquitetura.local.entity


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "events")
data class EventsEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,

    @ColumnInfo
    val title: String,

    @ColumnInfo
    val date: String,

    @ColumnInfo
    val location: String,

    )
