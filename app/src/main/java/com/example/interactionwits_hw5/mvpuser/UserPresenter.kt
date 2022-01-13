package com.example.interactionwits_hw5.mvpuser

import android.widget.Toast
import com.example.interactionwits_hw5.App
import com.example.interactionwits_hw5.data.GitHubUser
import com.example.interactionwits_hw5.data.GitHubUserRepository
import com.example.interactionwits_hw5.data.retrofit.datauser.GitHubUserRepoRepository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.annotations.NonNull
import io.reactivex.rxjava3.schedulers.Schedulers
import io.reactivex.rxjava3.subjects.BehaviorSubject
import moxy.MvpPresenter
import javax.inject.Inject

class UserPresenter(private val userName: String,
                    private val subject: @NonNull BehaviorSubject<GitHubUser> = BehaviorSubject.create()
                    ) : MvpPresenter<UserView>() {

    @Inject
    lateinit var userRepoRepository: GitHubUserRepoRepository
    @Inject
    lateinit var userRepository: GitHubUserRepository

    override fun onFirstViewAttach() {
        setSubject()
        userRepository.getUserByName(userName)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
               // viewState.showUser(it)
                subject.onNext(it)
            },{
                val errorMessage = it.message
                Toast.makeText(App.instance.getContext(), "$errorMessage", Toast.LENGTH_SHORT)
                    .show()
            })
    }
    private fun setSubject() {
        subject
            .subscribe({
                userRepoRepository.getUserByLogin(it.login!!)
                viewState.showUser(it)
            },{})
    }
}