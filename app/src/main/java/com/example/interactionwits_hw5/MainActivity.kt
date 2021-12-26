package com.example.interactionwits_hw5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.interactionwits_hw5.App.Navigation.navigatorHolder
import com.example.interactionwits_hw5.App.Navigation.router
import com.example.interactionwits_hw5.databinding.ActivityMainBinding
import com.example.interactionwits_hw5.mvpusers.UsersScreen
import com.example.interactionwits_hw5.navigation.CustomNavigator

class MainActivity : AppCompatActivity() {
    private val navigator = CustomNavigator(activity = this, R.id.container_for_fragments)
    private var binding: ActivityMainBinding? = null
    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) {
            binding = ActivityMainBinding.inflate(layoutInflater)
            setContentView(binding?.root)
            router.navigateTo(UsersScreen)
        }
    }

    override fun onPause() {
        navigatorHolder.removeNavigator()
        super.onPause()
    }
}