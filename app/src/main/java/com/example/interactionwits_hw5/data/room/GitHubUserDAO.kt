package com.example.interactionwits_hw5.data.room

import androidx.room.*
import androidx.room.OnConflictStrategy.REPLACE
import com.example.interactionwits_hw5.data.GitHubUser
import io.reactivex.rxjava3.core.Single

@Dao
interface GitHubUserDAO {
    @Query("SELECT * FROM GitHubUserTable")
    fun getUsers():Single<List<GitHubUser>>

    @Query("SELECT * FROM GitHubUserTable WHERE login LIKE :login LIMIT 1")
    fun getUserByLogin(login: String): Single<GitHubUser>

    @Insert(onConflict = REPLACE)
    fun saveUser(users: List<GitHubUser>)

    @Insert(onConflict = REPLACE)
    fun saveUser(user: GitHubUser)

    @Update
    fun update(user: List<GitHubUser>)

    @Update
    fun update(user: GitHubUser)

    @Delete
    fun delete(user: GitHubUser)
}