package com.example.interactionwits_hw5.mvpuser.di

import com.example.interactionwits_hw5.data.retrofit.GitHubApi
import com.example.interactionwits_hw5.data.retrofit.datauser.GitHubUserRepoRepository
import com.example.interactionwits_hw5.data.retrofit.datauser.GitHubUserRepoRepositoryImpl
import com.example.interactionwits_hw5.data.room.userrepo.DBGitHubStorage
import dagger.Module
import dagger.Provides

@Module
class RepoRepositoryModule {

    @FragmentScope
    @Provides
    fun provideRepository(api: GitHubApi, dbStorage: DBGitHubStorage): GitHubUserRepoRepository {
        return GitHubUserRepoRepositoryImpl(api, dbStorage)
    }
}