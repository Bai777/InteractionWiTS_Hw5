package com.example.interactionwits_hw5.data.retrofit.userrepo

import com.google.gson.annotations.SerializedName


data class GitHubRepoResponse(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String = "",
    @SerializedName("html_url")
    val html_url: String = ""
)