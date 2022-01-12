package com.example.interactionwits_hw5

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.interactionwits_hw5.databinding.ActivityMainBinding
import com.example.interactionwits_hw5.mvpusers.UsersScreen
import com.example.interactionwits_hw5.navigation.CustomNavigator
import com.example.interactionwits_hw5.navigation.CustomRouter
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.androidx.AppNavigator
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var navigatorHolder: NavigatorHolder
    @Inject
    lateinit var router: CustomRouter
    private val navigator = CustomNavigator(this, R.id.content)

    private var binding: ActivityMainBinding? = null

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding?.root)
        App.instance.applicationComponent.inject(this)
        if (savedInstanceState == null) {
            binding = ActivityMainBinding.inflate(layoutInflater)
            router.newRootScreen(UsersScreen())
        }
    }

    override fun onPause() {
        navigatorHolder.removeNavigator()
        super.onPause()
    }
}