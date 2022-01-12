package com.example.interactionwits_hw5.data.retrofit.datauser

import com.example.interactionwits_hw5.data.retrofit.GitHubApi
import com.example.interactionwits_hw5.data.room.userrepo.DBGitHubStorage
import com.example.interactionwits_hw5.data.room.userrepo.GitHubUserEntity
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class GitHubUserRepoRepositoryImpl
@Inject constructor(
    private val gitHubApi: GitHubApi,
    db: DBGitHubStorage
) : GitHubUserRepoRepository {

    private val dbDao = db.getGitHubUserDao()

    override fun getUserByLogin(login: String) {

        gitHubApi.fetchUserRepositories(login)
            .subscribeOn(Schedulers.io())
            .observeOn(Schedulers.computation())
            .subscribe({
                for (item in it) {
                    dbDao.insert(
                        GitHubUserEntity(0, login, item.id, item.name, item.html_url)
                    )
                }
            },{})
    }
}