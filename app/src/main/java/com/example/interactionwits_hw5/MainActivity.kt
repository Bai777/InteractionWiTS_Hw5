package com.example.interactionwits_hw5

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.interactionwits_hw5.databinding.ActivityMainBinding
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.androidx.AppNavigator
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    @Inject lateinit var navigatorHolder: NavigatorHolder
    private val navigator = AppNavigator(this, R.id.container)

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
//            router.navigateTo(UsersScreen)
        App.instance.appComponent.inject(this)
        }
    }

    override fun onPause() {
        navigatorHolder.removeNavigator()
        super.onPause()
    }
}