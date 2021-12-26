package com.example.interactionwits_hw5.data

import com.example.interactionwits_hw5.data.retrofit.GitHubApiFactory
import com.example.interactionwits_hw5.data.room.RoomFactory
import io.reactivex.rxjava3.core.Single

class GitHubUserRepositoryImpl() : GitHubUserRepository {

    private val gitHubApi = GitHubApiFactory.create()
    private val roomDb = RoomFactory.create().getGitHubUserDao()

    override fun getUsers(): Single<List<GitHubUser>> {
        return roomDb.getUsers()
            .flatMap {
                if (it.isEmpty()){
                    gitHubApi.fetchUsers()
                        .map { resultFromServer ->
                            roomDb.insert(resultFromServer)
                            resultFromServer
                        }
                }else{
                    Single.fromCallable {
                        roomDb.getUsers()
                    }
                    Single.just(it)
                }
            }
    }

    override fun getUserByName(user: String): Single<GitHubUser> {
        return gitHubApi.fetchUserByName(user)
    }

}