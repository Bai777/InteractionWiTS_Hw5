package com.example.interactionwits_hw5.mvpuser

import android.widget.Toast
import com.example.interactionwits_hw5.App
import com.example.interactionwits_hw5.data.GitHubUserRepository
import com.example.interactionwits_hw5.navigation.CustomRouter
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import moxy.MvpPresenter
import javax.inject.Inject

class UserPresenter(private val userName: String) : MvpPresenter<UserView>() {

    @Inject
    lateinit var userRepository: GitHubUserRepository

    override fun onFirstViewAttach() {
        userRepository.getUserByName(userName)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                viewState.showUser(it)
            },{
                val errorMessage = it.message
                Toast.makeText(App.instance.getContext(), "$errorMessage", Toast.LENGTH_SHORT)
                    .show()
            })
    }
}