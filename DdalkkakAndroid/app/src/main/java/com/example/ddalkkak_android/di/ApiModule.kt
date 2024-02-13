package com.example.ddalkkak_android.di;

import com.example.ddalkkak_android.api.LikeInfoService
import com.example.ddalkkak_android.api.UserInfoService
import com.example.ddalkkak_android.api.LinkInfoService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {

    @Provides
    @Singleton
    fun provideUserInfoService(@RetrofitModule.MoshiConverter retrofit: Retrofit): UserInfoService {
        return retrofit.create(UserInfoService::class.java)
    }

    @Provides
    @Singleton
    fun provideLinkInfoService(@RetrofitModule.GsonConverter retrofit: Retrofit): LinkInfoService {
        return retrofit.create(LinkInfoService::class.java)
    }

    @Provides
    @Singleton
    fun provideLikeInfoService(@RetrofitModule.GsonConverter retrofit: Retrofit): LikeInfoService {
        return retrofit.create(LikeInfoService::class.java)
    }
}