package com.example.ddalkkak_android.datasource

import com.example.ddalkkak_android.domain.ResponseLinkInfo

interface LikeInfoDataSource {
    suspend fun getLikes(userId: Long): List<ResponseLinkInfo>
    suspend fun putLike(linkId: Long, userId: Long)
    suspend fun deleteLike(likeId: Long)
}