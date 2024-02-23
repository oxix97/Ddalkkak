package com.example.ddalkkak_android.repository

import com.example.ddalkkak_android.mapper.LinkInfoMapper
import com.example.ddalkkak_android.datasource.LinkInfoDataSource
import com.example.ddalkkak_android.data.LinkInfo

class LinkInfoRepositoryImpl(private val linkInfoDataSource: LinkInfoDataSource) :
    LinkInfoRepository {
    override suspend fun getLinkInfo(): List<LinkInfo> {
        return linkInfoDataSource.getLinkInfo().map {
            LinkInfoMapper.responseLinkInfoToLinkInfo(it)
        }
    }

    override suspend fun getLinkInfoByUser(user: String): List<LinkInfo> {
        return linkInfoDataSource.getLinkInfoByUser(user).map {
            LinkInfoMapper.responseLinkInfoToLinkInfo(it)
        }
    }

    override suspend fun getLinkInfoByCreated(created: String): List<LinkInfo> {
        return linkInfoDataSource.getLinkInfoByCreated(created).map {
            LinkInfoMapper.responseLinkInfoToLinkInfo(it)
        }
    }

    override suspend fun getCreatedAts(): List<String> {
        return linkInfoDataSource.getCreatedAts()
    }

    override suspend fun getSearch(keyword: String): List<LinkInfo> {
        return linkInfoDataSource.getSearch(keyword).map {
            LinkInfoMapper.responseLinkInfoToLinkInfo(it)
        }
    }
}