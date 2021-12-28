package com.example.interactionwits_hw5.dagger

import com.example.interactionwits_hw5.App
import dagger.Module
import dagger.Provides

@Module
class AppModule(val app: App) {
    @Provides
    fun app(): App {
        return app
    }
}