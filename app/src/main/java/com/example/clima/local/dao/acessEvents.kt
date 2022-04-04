package com.example.clima.local.dao

import androidx.room.*
import com.example.clima.local.entity.EventsEntity

@Dao
interface AcessEvents{

    @Query("SELECT * FROM events")
    fun listAll(): MutableList<EventsEntity>

    @Query("SELECT * FROM events where id = :id")
    fun showForId(id: Int): EventsEntity

    @Query("SELECT COUNT(*) from events")
    fun countAll(): Int

    @Insert
    fun insert(vararg eventsEntity: EventsEntity)

    @Delete
    fun delete(eventsEntity: EventsEntity)

    @Update
    fun update(eventsEntity: EventsEntity)
}