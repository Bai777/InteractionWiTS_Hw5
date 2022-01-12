package com.example.interactionwits_hw5.di

import android.content.Context
import com.example.interactionwits_hw5.MainActivity
import com.example.interactionwits_hw5.mvpuser.UserPresenter
import com.example.interactionwits_hw5.mvpusers.UsersPresenter
import com.example.interactionwits_hw5.di.ApplicationComponent
import com.example.interactionwits_hw5.mvpuser.di.GitHubUserComponent
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        CiceroneModule::class,
        NetworkModule::class,
        RepositoryModule::class,
        RoomModule::class
    ]
)
interface ApplicationComponent {

    fun provideApplicationComponent(): GitHubUserComponent.Builder

    @Component.Builder
    interface Builder{
        @BindsInstance
        fun setContext(context: Context): Builder

        fun build(): ApplicationComponent
    }



    fun inject(mainActivity: MainActivity)
    fun inject(userPresenter: UserPresenter)
    fun inject(usersPresenter: UsersPresenter)

}