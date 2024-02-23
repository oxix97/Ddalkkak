package com.example.ddalkkak_android.datasource

import com.example.ddalkkak_android.domain.ResponseLinkInfo
import retrofit2.http.GET
import retrofit2.http.Query

interface LikeInfoDataSource {
    suspend fun getLikes(userId: Long): List<ResponseLinkInfo>
    suspend fun putLike(linkId: Long, userId: Long)
    suspend fun deleteLike(likeId: Long)
}