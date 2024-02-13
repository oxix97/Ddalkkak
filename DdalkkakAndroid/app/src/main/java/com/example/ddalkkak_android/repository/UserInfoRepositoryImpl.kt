package com.example.ddalkkak_android.repository

import com.example.ddalkkak_android.data.UserInfo
import com.example.ddalkkak_android.datasource.UserInfoDataSource
import com.example.ddalkkak_android.mapper.UserInfoMapper

class UserInfoRepositoryImpl(private val datasource: UserInfoDataSource) : UserInfoRepository {
    override suspend fun getUser(userId: String): UserInfo {
        return UserInfoMapper.responseToUserInfo(datasource.getUser(userId))
    }

    override suspend fun getUsers(): List<UserInfo> {
        return datasource.getUsers().map(UserInfoMapper::responseToUserInfo)
    }
}
