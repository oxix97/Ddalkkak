package com.example.ddalkkak_android.repository

import com.example.ddalkkak_android.data.LinkInfo

interface LinkInfoRepository {
    suspend fun getLinkInfo(): List<LinkInfo>
    suspend fun getLinkInfoByUser(user: String): List<LinkInfo>
    suspend fun getLinkInfoByCreated(created: String): List<LinkInfo>
    suspend fun getCreatedAts(): List<String>
    suspend fun getSearch(keyword: String): List<LinkInfo>
}