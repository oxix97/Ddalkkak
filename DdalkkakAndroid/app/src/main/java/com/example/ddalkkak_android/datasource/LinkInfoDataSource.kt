package com.example.ddalkkak_android.datasource;

import com.example.ddalkkak_android.domain.ResponseLinkInfo

interface LinkInfoDataSource {
    suspend fun getLinkInfo(): List<ResponseLinkInfo>

    suspend fun getLinkInfoByUser(user: String): List<ResponseLinkInfo>

    suspend fun getLinkInfoByCreated(created: String): List<ResponseLinkInfo>

    suspend fun getCreatedAts(): List<String>

}
