package com.example.clima.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.clima.local.dao.AcessEvents
import com.example.clima.local.entity.EventsEntity

@Database(
    entities = [EventsEntity::class],
    version = 1,
    exportSchema = false
)

abstract class AppDataBase : RoomDatabase() {

    abstract fun acessEvents(): AcessEvents

}
