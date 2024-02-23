package com.example.ddalkkak_android.di

import android.content.Context
import androidx.room.Room
import com.example.ddalkkak_android.dao.AppDatabase
import com.example.ddalkkak_android.dao.LinkInfoDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DatabaseModule {
    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context) =
        Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "User_data"
        ).fallbackToDestructiveMigration()
            .build()

    @Provides
    fun provideLinkInfoDao(appDatabase: AppDatabase): LinkInfoDao = appDatabase.linkInfoDao()
}