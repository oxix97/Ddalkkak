package com.example.ddalkkak_android.datasource;

import com.example.ddalkkak_android.api.UserInfoService
import com.example.ddalkkak_android.data.UserInfo
import com.example.ddalkkak_android.domain.ResponseUserInfo

class UserInfoDataSourceImpl(private val userInfoService: UserInfoService) : UserInfoDataSource {
    override suspend fun getUsers(): List<ResponseUserInfo> {
        return userInfoService.getUsers()
    }

    override suspend fun getUser(userId: String): ResponseUserInfo {
        return userInfoService.getUser(userId)
    }

}
