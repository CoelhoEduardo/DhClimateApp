package com.example.clima.arquitetura.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.clima.arquitetura.local.dao.AcessEvents
import com.example.clima.arquitetura.local.entity.Converter
import com.example.clima.arquitetura.local.entity.EventsEntity

@Database(
    entities = [EventsEntity::class],
    version = 1,
    exportSchema = false
)

@TypeConverters(Converter::class)
abstract class AppDataBase : RoomDatabase() {

    abstract fun acessEvents(): AcessEvents

}
