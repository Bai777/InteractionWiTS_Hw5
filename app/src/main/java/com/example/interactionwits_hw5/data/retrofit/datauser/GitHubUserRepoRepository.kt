package com.example.interactionwits_hw5.data.retrofit.datauser

interface GitHubUserRepoRepository {
    fun getUserByLogin(login: String)
}