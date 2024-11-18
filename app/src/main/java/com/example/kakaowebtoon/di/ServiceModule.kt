package com.example.kakaowebtoon.di

import com.example.kakaowebtoon.data.dataremote.service.DummyService
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
    fun providesService(retrofit: Retrofit): DummyService =
        retrofit.create(DummyService::class.java)
}
