package com.example.interactionwits_hw5.dagger

import androidx.room.Room
import com.example.interactionwits_hw5.App
import com.example.interactionwits_hw5.data.room.DBStorage
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CacheModule {
    @Singleton
    @Provides
    fun database(app: App): DBStorage = Room.databaseBuilder(app, DBStorage::class.java, "github.db")
        .build()
}