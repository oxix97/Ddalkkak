package com.example.ddalkkak_android.datasource

import com.example.ddalkkak_android.api.LikeInfoService
import com.example.ddalkkak_android.domain.ResponseLinkInfo

class LikeInfoDataSourceImpl(private val likeInfoService: LikeInfoService) : LikeInfoDataSource {
    override suspend fun getLikes(userId: Long): List<ResponseLinkInfo> {
        return likeInfoService.getLikes(userId)
    }

    override suspend fun putLike(linkId: Long, userId: Long) {
        return likeInfoService.putLike(linkId,userId)
    }

    override suspend fun deleteLike(likeId: Long) {
        return likeInfoService.deleteLike(likeId)
    }
}