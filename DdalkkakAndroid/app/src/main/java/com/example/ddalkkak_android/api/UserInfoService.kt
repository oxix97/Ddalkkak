package com.example.ddalkkak_android.api

import com.example.ddalkkak_android.domain.ResponseUserInfo
import retrofit2.http.GET
import retrofit2.http.Path

interface UserInfoService {
    @GET("users")
    suspend fun getUsers(): List<ResponseUserInfo>

    @GET("users/{userId}")
    suspend fun getUser(
        @Path("userId") userId: String
    ): ResponseUserInfo
}