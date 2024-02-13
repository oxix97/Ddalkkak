package com.example.ddalkkak_android.mapper

import com.example.ddalkkak_android.data.LinkInfo
import com.example.ddalkkak_android.domain.ResponseLinkInfo

object LinkInfoMapper {
    fun responseLinkInfoToLinkInfo(data: ResponseLinkInfo): LinkInfo {
        return LinkInfo(
            data.id,
            data.user,
            data.username,
            data.title,
            data.originalUrl,
            data.thumbUrl,
            data.slackCreatedAt
        )
    }
}