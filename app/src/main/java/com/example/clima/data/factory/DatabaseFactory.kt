package com.example.clima.data.factory

import android.content.Context
import androidx.room.Room
import com.example.clima.local.AppDataBase

object DatabaseFactory {

    private var instance: AppDataBase? = null

    @JvmStatic
    fun getDatabase(context: Context) = instance ?: build(context)

    private fun build(context: Context): AppDataBase {
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