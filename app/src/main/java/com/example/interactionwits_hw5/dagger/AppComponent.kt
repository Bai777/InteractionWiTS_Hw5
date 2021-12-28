package com.example.interactionwits_hw5.dagger

import com.example.interactionwits_hw5.MainActivity
import com.example.interactionwits_hw5.mvpuser.UserFragment
import com.example.interactionwits_hw5.mvpuser.UserPresenter
import com.example.interactionwits_hw5.mvpusers.UsersFragment
import com.example.interactionwits_hw5.mvpusers.UsersPresenter
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        CiceroneModule::class,
        CacheModule::class,
        ApiModule::class
    ]
)
interface AppComponent {
    fun inject(mainActivity: MainActivity)
    fun inject(userFragment: UserFragment)
    fun inject(usersFragment: UsersFragment)
    fun inject(userPresenter: UserPresenter)
    fun inject(usersPresenter: UsersPresenter)
}