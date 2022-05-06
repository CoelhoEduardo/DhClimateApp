package com.example.clima.arquitetura.local

import androidx.room.*
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.clima.arquitetura.local.dao.EventsDao
import com.example.clima.arquitetura.local.entity.Converters
import com.example.clima.arquitetura.local.entity.EventsEntity

@Database(
    entities = [EventsEntity::class],
    version = 2,
    exportSchema = false,

    )

@TypeConverters(Converters::class)
abstract class AppDataBase : RoomDatabase() {
    abstract fun EventsDao(): EventsDao
}

val MIGRATION_1_2 = object : Migration(1, 2) {
    override fun migrate(dataBase: SupportSQLiteDatabase) {
        dataBase.execSQL("ALTER TABLE events ADD COLUMN categories TEXT NOT NULL DEFAULT ''")
        dataBase.execSQL("ALTER TABLE events ADD COLUMN sources TEXT NOT NULL DEFAULT ''")
        dataBase.execSQL("ALTER TABLE events ADD COLUMN geometryItem TEXT NOT NULL DEFAULT ''")
        dataBase.execSQL("ALTER TABLE events RENAME COLUMN location TO link")
        dataBase.execSQL("ALTER TABLE events RENAME COLUMN date TO idApi")
    }
}
