package com.example.clima.arquitetura.factory

import androidx.room.Room
import com.example.clima.arquitetura.local.AppDataBase
//import com.example.clima.screen.MapFragment
import kotlin.coroutines.coroutineContext

//object DatabaseFactory {
//
//    private var instance: AppDataBase? = null
//
//    @JvmStatic
//    fun getDatabase(): AppDataBase {
//        return instance ?: build()
//    }
//
//    private fun build(context: MapFragment): AppDataBase {
//        val database = Room.databaseBuilder(
//            context.applicationContext,
//            AppDataBase::class.java, "events-database"
//        )
//        database.allowMainThreadQueries()
//        val appDataBase = database.build()
//        instance = appDataBase
//        return appDataBase
//    }
//
//    fun destroyInstance() {
//        instance = null
//    }
//
//
//}
