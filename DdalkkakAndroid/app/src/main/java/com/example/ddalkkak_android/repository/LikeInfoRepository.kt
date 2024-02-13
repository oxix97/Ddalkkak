package com.example.ddalkkak_android.repository

import com.example.ddalkkak_android.data.LinkInfo

interface LikeInfoRepository {
    suspend fun getLikes(userId: Long): List<LinkInfo>
    suspend fun putLike(linkId: Long, userId: Long)
    suspend fun deleteLike(likeId: Long)
}