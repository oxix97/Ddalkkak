package com.example.ddalkkak_android.repository

import com.example.ddalkkak_android.data.UserInfo

interface UserInfoRepository {
    suspend fun getUser(userId: String): UserInfo
    suspend fun getUsers(): List<UserInfo>
}
