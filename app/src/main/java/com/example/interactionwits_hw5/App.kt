package com.example.interactionwits_hw5

import android.app.Application
import android.content.Context
import com.example.interactionwits_hw5.dagger.AppComponent
import com.example.interactionwits_hw5.dagger.DaggerAppComponent

class App : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        instance = this
        appComponent = DaggerAppComponent.builder()
            .setContext(this)
            .build()
    }

    companion object Navigation {
        lateinit var instance: App
    }
        fun getContext(): Context = applicationContext

}