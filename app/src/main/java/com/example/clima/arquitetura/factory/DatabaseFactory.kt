package com.example.clima.arquitetura.factory

import android.content.Context
import androidx.room.Room
import com.example.clima.arquitetura.local.AppDataBase
import java.lang.IllegalStateException
import kotlin.coroutines.coroutineContext

object DatabaseFactory {

    private var instance: AppDataBase? = null

    @JvmStatic
    fun getDatabase() = instance?: throw IllegalStateException("Database is not initialized")

    fun build(context: Context): AppDataBase {
        val currentInstance = instance
        if(currentInstance != null) return currentInstance

        val database = Room.databaseBuilder(
            context.applicationContext,
            AppDataBase::class.java, "events-database"
        )
        database.allowMainThreadQueries()
        val appDataBase = database.build()
        instance = appDataBase
        return appDataBase
    }

    fun destroyInstance() {
        instance = null
    }


}
