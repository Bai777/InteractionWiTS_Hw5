package com.example.interactionwits_hw5.mvpuser

import com.example.interactionwits_hw5.data.GitHubUser
import moxy.MvpView
import moxy.viewstate.strategy.alias.SingleState

interface UserView : MvpView {
    @SingleState
    fun showUser(user: GitHubUser)
}