package com.example.interactionwits_hw5.data.room.userrepo

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [GitHubUserEntity::class], version = 1, exportSchema = false)
abstract class DBGitHubStorage : RoomDatabase() {

    abstract fun getGitHubUserDao(): GitHubUserDao

}