package com.example.ddalkkak_android.datasource;

import com.example.ddalkkak_android.domain.ResponseUserInfo

interface UserInfoDataSource {
    suspend fun getUsers(): List<ResponseUserInfo>

    suspend fun getUser(userId: String): ResponseUserInfo
}
