package com.example.kakaowebtoon.di

import com.example.kakaowebtoon.data.dataremote.datasource.EpisodeRemoteDataSource
import com.example.kakaowebtoon.data.dataremote.datasource.WebtoonsRemoteDataSource
import com.example.kakaowebtoon.data.dataremote.datasourceimpl.EpisodeRemoteDataSourceImpl
import com.example.kakaowebtoon.data.dataremote.datasourceimpl.WebtoonsRemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {
    @Binds
    @Singleton
    abstract fun bindsWebtoonsRemoteDataSource(webtoonsRemoteDataSourceImpl: WebtoonsRemoteDataSourceImpl): WebtoonsRemoteDataSource

    @Binds
    @Singleton
    abstract fun bindsEpisodeRemoteDataSource(episodeRemoteDataSourceImpl: EpisodeRemoteDataSourceImpl): EpisodeRemoteDataSource
}
