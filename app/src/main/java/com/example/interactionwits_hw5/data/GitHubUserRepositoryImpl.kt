package com.example.interactionwits_hw5.data

import com.example.interactionwits_hw5.data.retrofit.GitHubApiFactory
import io.reactivex.rxjava3.core.Single

class GitHubUserRepositoryImpl : GitHubUserRepository {

    private val gitHubApi = GitHubApiFactory.create()

    override fun getUsers(): Single<List<GitHubUser>> {
        return gitHubApi.fetchUsers()
    }

    override fun getUserByName(user: String): Single<GitHubUser> {
        return gitHubApi.fetchUserByName(user)
    }
}