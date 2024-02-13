package com.example.ddalkkak_android.api

import com.example.ddalkkak_android.domain.ResponseLinkInfo
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.Query

interface LikeInfoService {

    @GET("likes/{userId}")
    suspend fun getLikes(
        @Path("userId") userId: Long
    ): List<ResponseLinkInfo>

    @PUT("likes")
    suspend fun putLike(
        @Query("linkId") linkId: Long,
        @Query("userId") userId: Long
    )

    @DELETE("likes")
    suspend fun deleteLike(
        @Query("likeId") likeId: Long
    )
}