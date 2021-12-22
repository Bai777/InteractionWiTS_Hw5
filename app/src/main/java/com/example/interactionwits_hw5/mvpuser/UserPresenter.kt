package com.example.interactionwits_hw5.mvpuser

import android.widget.Toast
import com.example.interactionwits_hw5.App
import com.example.interactionwits_hw5.data.room.GitHubUserDAO
import com.example.interactionwits_hw5.data.room.RoomFactory
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import moxy.MvpPresenter

class UserPresenter(
    private val roomDb: GitHubUserDAO = RoomFactory.create().getGitHubUserDao(),
    private val userName: String
) : MvpPresenter<UserView>() {

    override fun onFirstViewAttach() {
        roomDb.getUserByLogin(userName)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                viewState.showUser(it)
            }, {
                val errorMessage = it.message
                Toast.makeText(App.instance.getContext(), "$errorMessage", Toast.LENGTH_SHORT)
                    .show()
            })
    }
}