package com.example.interactionwits_hw5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.interactionwits_hw5.App.Navigation.navigatorHolder
import com.example.interactionwits_hw5.App.Navigation.router
import com.example.interactionwits_hw5.mvpusers.UsersScreen
import com.example.interactionwits_hw5.navigation.CustomNavigator

class MainActivity : AppCompatActivity() {
    private val navigator = CustomNavigator(activity = this, R.id.content)

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) {
            router.navigateTo(UsersScreen)
        }
    }

    override fun onPause() {
        navigatorHolder.removeNavigator()
        super.onPause()
    }
}