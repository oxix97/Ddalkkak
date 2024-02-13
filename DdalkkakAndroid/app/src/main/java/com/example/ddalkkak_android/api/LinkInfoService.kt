package com.example.ddalkkak_android.api

import com.example.ddalkkak_android.domain.ResponseLinkInfo
import retrofit2.http.GET
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.Query

interface LinkInfoService {
    @GET("link-info/all")
    suspend fun getLinks(): List<ResponseLinkInfo>

    @GET("link-info")
    suspend fun getLinkByCreated(
        @Query("created") created: String
    ): List<ResponseLinkInfo>

    @GET("link-info/{userId}")
    suspend fun getLinkByUser(
        @Path("userId") userId: String
    ): List<ResponseLinkInfo>

    @GET("created/all")
    suspend fun getCreatedAts(): List<String>
}