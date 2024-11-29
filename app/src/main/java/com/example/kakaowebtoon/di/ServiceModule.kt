package com.example.kakaowebtoon.di

import com.example.kakaowebtoon.data.dataremote.service.EpisodeService
import com.example.kakaowebtoon.data.dataremote.service.WebtoonsService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ServiceModule {
    @Provides
    @Singleton
    fun providesWebtoonsService(retrofit: Retrofit): WebtoonsService =
        retrofit.create(WebtoonsService::class.java)

    @Provides
    @Singleton
    fun providesEpisodeService(retrofit: Retrofit): EpisodeService =
        retrofit.create(EpisodeService::class.java)
}
