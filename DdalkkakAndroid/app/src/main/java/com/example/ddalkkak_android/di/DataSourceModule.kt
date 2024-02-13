package com.example.ddalkkak_android.di;

import com.example.ddalkkak_android.api.LikeInfoService
import com.example.ddalkkak_android.api.UserInfoService
import com.example.ddalkkak_android.api.LinkInfoService
import com.example.ddalkkak_android.datasource.LikeInfoDataSource
import com.example.ddalkkak_android.datasource.LikeInfoDataSourceImpl
import com.example.ddalkkak_android.datasource.LinkInfoDataSource
import com.example.ddalkkak_android.datasource.LinkInfoDataSourceImpl
import com.example.ddalkkak_android.datasource.UserInfoDataSource
import com.example.ddalkkak_android.datasource.UserInfoDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {

    @Provides
    @Singleton
    fun provideUserInfoDataSource(userService: UserInfoService): UserInfoDataSource {
        return UserInfoDataSourceImpl(userService)
    }

    @Provides
    @Singleton
    fun provideLinkInfoDataSource(linkInfoService: LinkInfoService): LinkInfoDataSource {
        return LinkInfoDataSourceImpl(linkInfoService)
    }

    @Provides
    @Singleton
    fun provideLikeInfoDataSource(likeInfoService: LikeInfoService): LikeInfoDataSource {
        return LikeInfoDataSourceImpl(likeInfoService)
    }
}