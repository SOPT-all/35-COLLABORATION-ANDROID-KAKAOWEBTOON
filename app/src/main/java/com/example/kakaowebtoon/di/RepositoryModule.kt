package com.example.kakaowebtoon.di

import com.example.kakaowebtoon.data.repositoryimpl.EpisodeRepositoryImpl
import com.example.kakaowebtoon.data.repositoryimpl.WebtoonsRepositoryImpl
import com.example.kakaowebtoon.domain.repository.EpisodeRepository
import com.example.kakaowebtoon.domain.repository.WebtoonsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindWebtoonsRepository(webtoonsRepositoryImpl: WebtoonsRepositoryImpl): WebtoonsRepository

    @Binds
    @Singleton
    abstract fun bindEpisodeRepository(episodeRepositoryImpl: EpisodeRepositoryImpl): EpisodeRepository
}
