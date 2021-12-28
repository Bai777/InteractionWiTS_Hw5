package com.example.interactionwits_hw5.data.room

import androidx.room.Room
import com.example.interactionwits_hw5.App

object RoomFactory {
        private val database: DBStorage by lazy {
        Room.databaseBuilder(App.ContextHolder.context,
        DBStorage::class.java,
            "github.db").build()
    }

    fun create(): DBStorage = database
}