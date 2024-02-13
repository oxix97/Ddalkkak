package com.example.ddalkkak_android.domain

data class ResponseLinkInfo(
     val admin: Boolean,
     val authorName: String?,
     val createdAt: String,
     val id: Int,
     val originalUrl: String,
     val slackCreatedAt: String,
     val thumbUrl: String?,
     val title: String?,
     val ts: String,
     val updatedAt: String,
     val user: String,
     val username: String
)