package com.example.clima.arquitetura.local.dao

import androidx.room.*
import com.example.clima.arquitetura.local.entity.EventsEntity

@Dao
interface EventsDao {

    @Query("SELECT * FROM events")
    fun listAll(): List<EventsEntity>

    @Query("SELECT * FROM events where id = :id")
    fun showForId(id: Int): EventsEntity

    @Query("SELECT COUNT(*) from events")
    fun countAll(): Int

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(vararg eventsEntity: EventsEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(eventsEntity: List<EventsEntity>)

    @Delete
    fun delete(eventsEntity: EventsEntity)

    @Update
    fun update(eventsEntity: EventsEntity)
}
