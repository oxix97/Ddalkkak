package com.example.ddalkkak_android.repository

import com.example.ddalkkak_android.data.LinkInfo
import com.example.ddalkkak_android.datasource.LikeInfoDataSource
import com.example.ddalkkak_android.mapper.LinkInfoMapper

class LikeInfoRepositoryImpl(private val likeInfoDataSource: LikeInfoDataSource) :
    LikeInfoRepository {
    override suspend fun getLikes(userId: Long): List<LinkInfo> {
        return likeInfoDataSource.getLikes(userId).map {
            LinkInfoMapper.responseLinkInfoToLinkInfo(it)
        }
    }

    override suspend fun putLike(linkId: Long, userId: Long) {
        return likeInfoDataSource.putLike(linkId, userId)
    }

    override suspend fun deleteLike(likeId: Long) {
        return likeInfoDataSource.deleteLike(likeId)
    }
}