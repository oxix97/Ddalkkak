package com.example.ddalkkak_android.di;

import com.example.ddalkkak_android.datasource.LikeInfoDataSource
import com.example.ddalkkak_android.datasource.LinkInfoDataSource
import com.example.ddalkkak_android.datasource.UserInfoDataSource
import com.example.ddalkkak_android.repository.LikeInfoRepository
import com.example.ddalkkak_android.repository.LikeInfoRepositoryImpl
import com.example.ddalkkak_android.repository.LinkInfoRepository
import com.example.ddalkkak_android.repository.LinkInfoRepositoryImpl
import com.example.ddalkkak_android.repository.UserInfoRepository
import com.example.ddalkkak_android.repository.UserInfoRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideUserInfoRepository(datasource: UserInfoDataSource): UserInfoRepository {
        return UserInfoRepositoryImpl(datasource)
    }

    @Provides
    @Singleton
    fun provideLinkInfoRepository(datasource: LinkInfoDataSource): LinkInfoRepository {
        return LinkInfoRepositoryImpl(datasource)
    }

    @Provides
    @Singleton
    fun provideLikeInfoRepository(datasource: LikeInfoDataSource): LikeInfoRepository {
        return LikeInfoRepositoryImpl(datasource)
    }
}
