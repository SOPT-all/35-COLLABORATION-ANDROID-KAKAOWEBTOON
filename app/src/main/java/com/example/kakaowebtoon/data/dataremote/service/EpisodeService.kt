package com.example.kakaowebtoon.data.dataremote.service

import com.example.kakaowebtoon.data.dataremote.model.response.EpisodeDetailResponseDto
import com.example.kakaowebtoon.data.dataremote.model.response.EpisodesResponseDto
import retrofit2.http.GET
import retrofit2.http.Path

interface EpisodeService {
    @GET("/api/v1/episodes/{webtoonId}")
    suspend fun episodeDetail(
        @Path("webtoonId") webtoonId: Int
    ): EpisodeDetailResponseDto

    @GET("/api/v1/episodes/details/{webtoonId}")
    suspend fun episodes(
        @Path("webtoonId") webtoonId: Int
    ): EpisodesResponseDto
}
