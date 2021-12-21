package com.example.interactionwits_hw5.mvpusers

import android.widget.Toast
import com.example.interactionwits_hw5.App
import com.example.interactionwits_hw5.data.GitHubUserRepository
import com.example.interactionwits_hw5.mvpuser.UserScreen
import com.example.interactionwits_hw5.navigation.CustomRouter
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import moxy.MvpPresenter

class UsersPresenter (
    private val userRepository: GitHubUserRepository,
    private val router: CustomRouter
): MvpPresenter<UsersView>() {

    override fun onFirstViewAttach() {
        updateContent()
    }

    fun goToNextScreen(name: String) {
        router.navigateTo(UserScreen(name))
    }

    private fun updateContent() {
        userRepository.getUsers()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                viewState.showUsers(it)
            },{
                val errorMessage = it.message
                Toast.makeText(App.instance.getContext(), "$errorMessage", Toast.LENGTH_SHORT)
                    .show()
            })
    }
}