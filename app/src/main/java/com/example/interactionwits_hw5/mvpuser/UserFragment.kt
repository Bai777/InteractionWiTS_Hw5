package com.example.interactionwits_hw5.mvpuser

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.interactionwits_hw5.R
import com.example.interactionwits_hw5.data.GitHubUser
import com.example.interactionwits_hw5.data.GitHubUserRepositoryFactory
import com.example.interactionwits_hw5.databinding.ViewUserBinding
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class UserFragment : MvpAppCompatFragment(R.layout.view_user), UserView {

    private lateinit var viewBinding: ViewUserBinding

    private val userName: String by lazy {
        arguments?.getString(ARG_USER_NAME).orEmpty()
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinding = ViewUserBinding.bind(view)
        viewBinding.userLogin.text = userName
    }

    override fun showUser(user: GitHubUser) {
        viewBinding.userLogin.text = user.name
    }

    companion object {
        private const val ARG_USER_NAME = "arg_user_name"

        fun newInstance(userName: String): Fragment =
            UserFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_USER_NAME, userName)
                }
            }
    }
}