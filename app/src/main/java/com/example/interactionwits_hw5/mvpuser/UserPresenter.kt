package com.example.interactionwits_hw5.mvpuser

import com.example.interactionwits_hw5.data.GitHubUserRepository
import com.example.interactionwits_hw5.navigation.CustomRouter
import moxy.MvpPresenter

class UserPresenter (
    private val userName: String,
    private val userRepository: GitHubUserRepository,
    private val router: CustomRouter
) : MvpPresenter<UserView>() {

    override fun onFirstViewAttach() {
        userRepository
            .getUserByName(userName)
            ?.let(viewState::showUser)
    }
}