package com.example.ddalkkak_android.di;

import com.example.ddalkkak_android.BuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Qualifier
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {
    private val BASE_URL = BuildConfig.BASE_URL

    private fun httpLoggingInterceptor(): HttpLoggingInterceptor {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return loggingInterceptor
    }

    private fun getOkHttpClient(): OkHttpClient = OkHttpClient.Builder()
        .connectTimeout(20, TimeUnit.SECONDS)
        .writeTimeout(20, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .addInterceptor(httpLoggingInterceptor())
//        .addInterceptor(AuthInterceptor())
        .build()

    @GsonConverter
    @Provides
    @Singleton
    fun provideRetrofitObjectGson(): Retrofit {
        return Retrofit.Builder().baseUrl(BASE_URL).client(getOkHttpClient())
            .addConverterFactory(GsonConverterFactory.create()).build()
    }

    @MoshiConverter
    @Provides
    @Singleton
    fun provideRetrofitObjectMoshi(
        moshi: com.squareup.moshi.Moshi
    ): Retrofit {
        return Retrofit.Builder().baseUrl(BASE_URL).client(getOkHttpClient())
            .addConverterFactory(MoshiConverterFactory.create(moshi)).build()
    }

    @Qualifier
    @Retention(AnnotationRetention.BINARY)
    annotation class GsonConverter

    @Retention(AnnotationRetention.BINARY)
    @Qualifier
    annotation class MoshiConverter
}