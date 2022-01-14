package com.example.interactionwits_hw5.mvpusers

import com.example.interactionwits_hw5.data.GitHubUser
import moxy.MvpView
import moxy.viewstate.strategy.alias.SingleState

interface UsersView : MvpView {
    @SingleState
    fun showUsers(users: List<GitHubUser>)

    @SingleState
    fun setProgressBar(state: Boolean)
}