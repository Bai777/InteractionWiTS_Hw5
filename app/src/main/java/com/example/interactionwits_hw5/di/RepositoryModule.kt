package com.example.interactionwits_hw5.di

import com.example.interactionwits_hw5.data.GitHubUserRepository
import com.example.interactionwits_hw5.data.GitHubUserRepositoryImpl
import com.example.interactionwits_hw5.data.retrofit.GitHubApi
import com.example.interactionwits_hw5.data.room.DBStorage
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class RepositoryModule {
    @Provides
    fun provideRepository(api: GitHubApi, dbStorage: DBStorage): GitHubUserRepository{
        return GitHubUserRepositoryImpl(api, dbStorage)
    }
}