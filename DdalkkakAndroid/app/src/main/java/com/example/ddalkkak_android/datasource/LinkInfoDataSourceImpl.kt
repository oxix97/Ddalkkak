package com.example.ddalkkak_android.datasource

import com.example.ddalkkak_android.api.LinkInfoService
import com.example.ddalkkak_android.domain.ResponseLinkInfo

class LinkInfoDataSourceImpl(private val linkInfoService: LinkInfoService) : LinkInfoDataSource {
    override suspend fun getLinkInfo(): List<ResponseLinkInfo> {
        return linkInfoService.getLinks()
    }

    override suspend fun getLinkInfoByUser(user: String): List<ResponseLinkInfo> {
        return linkInfoService.getLinkByUser(user)
    }

    override suspend fun getLinkInfoByCreated(created: String): List<ResponseLinkInfo> {
        return linkInfoService.getLinkByCreated(created)
    }

    override suspend fun getCreatedAts(): List<String> {
        return linkInfoService.getCreatedAts()
    }
}