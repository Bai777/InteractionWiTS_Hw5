package com.example.interactionwits_hw5.dagger

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
    fun provideRepository(@Named("provRep") api: GitHubApi, dbStorage: DBStorage): GitHubUserRepository{
        return GitHubUserRepositoryImpl(api, dbStorage)
    }
}