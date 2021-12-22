package com.example.interactionwits_hw5.data

object GitHubUserRepositoryFactory {
    fun create(): GitHubUserRepository = GitHubUserRepositoryImpl()
}