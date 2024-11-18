package com.example.kakaowebtoon.data.repositoryimpl

import com.example.kakaowebtoon.data.dataremote.datasource.DummyRemoteDataSource
import com.example.kakaowebtoon.data.mapper.toDomainModel
import com.example.kakaowebtoon.domain.repository.DummyRepository
import com.example.kakaowebtoon.domain.model.DummyDataClass
import jakarta.inject.Inject


class DummyRepositoryImpl @Inject constructor(
    private val remoteDataSource: DummyRemoteDataSource
) : DummyRepository {

    override suspend fun funName(): Result<List<DummyDataClass>> = runCatching {
        remoteDataSource.funName().map {
            it.toDomainModel()
        }
    }
}
