package com.example.interactionwits_hw5

import android.app.Application
import android.content.Context
import com.example.interactionwits_hw5.di.ApplicationComponent
import com.example.interactionwits_hw5.di.DaggerApplicationComponent

class App : Application() {

    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        instance = this
        applicationComponent = DaggerApplicationComponent.builder()
            .setContext(this)
            .build()
    }

    companion object  {
        lateinit var instance: App
    }
        fun getContext(): Context = applicationContext

}