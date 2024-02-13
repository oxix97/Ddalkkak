package com.example.ddalkkak_android.data

data class LinkInfo(
    val linkId : Int,
    val user: String,
    val username: String?,
    val title: String?,
    val originalUrl: String?,
    val thumbUrl: String?,
    val slackCreatedAt: String,
    val isLike: Boolean = false
)
