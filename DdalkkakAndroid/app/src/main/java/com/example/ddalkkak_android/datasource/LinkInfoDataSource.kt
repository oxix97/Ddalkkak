package com.example.ddalkkak_android.datasource;

import com.example.ddalkkak_android.domain.ResponseLinkInfo
import retrofit2.http.GET
import retrofit2.http.Query

interface LinkInfoDataSource {
    suspend fun getLinkInfo(): List<ResponseLinkInfo>

    suspend fun getLinkInfoByUser(user: String): List<ResponseLinkInfo>

    suspend fun getLinkInfoByCreated(created: String): List<ResponseLinkInfo>

    suspend fun getCreatedAts(): List<String>
    suspend fun getSearch(keyword: String) : List<ResponseLinkInfo>

}
