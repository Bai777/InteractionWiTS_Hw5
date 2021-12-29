package com.example.interactionwits_hw5.dagger

import android.content.Context
import com.example.interactionwits_hw5.MainActivity
import com.example.interactionwits_hw5.mvpuser.UserFragment
import com.example.interactionwits_hw5.mvpuser.UserPresenter
import com.example.interactionwits_hw5.mvpusers.UsersFragment
import com.example.interactionwits_hw5.mvpusers.UsersPresenter
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        NetworkModule::class,
        CiceroneModule::class,
        RoomModule::class,
        RepositoryModule::class
    ]
)
interface AppComponent {

    @Component.Builder
    interface Builder{
        @BindsInstance
        fun setContext(context: Context): Builder

        fun build(): AppComponent
    }



    fun inject(mainActivity: MainActivity)
    fun inject(userPresenter: UserPresenter)
    fun inject(usersPresenter: UsersPresenter)
}