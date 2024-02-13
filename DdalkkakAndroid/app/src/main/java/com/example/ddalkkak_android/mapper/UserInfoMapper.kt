package com.example.ddalkkak_android.mapper

import com.example.ddalkkak_android.data.UserInfo
import com.example.ddalkkak_android.domain.ResponseUserInfo

object UserInfoMapper {
    fun responseToUserInfo(data: ResponseUserInfo): UserInfo {
        return UserInfo(
            data.id,
            data.name,
            data.admin,
            data.createdAt,
            data.updatedAt
        )
    }
}