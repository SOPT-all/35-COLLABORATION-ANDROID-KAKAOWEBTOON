package com.example.kakaowebtoon.data.dataremote.service

import com.example.kakaowebtoon.data.dataremote.model.response.EpisodeDetailResponseDto
import retrofit2.http.GET
import retrofit2.http.Path

interface EpisodeService {
    @GET("/api/v1/episodes/{webtoonId}")
    suspend fun episodeDetail(
        @Path("webtoonId") webtoonId: Int
    ): EpisodeDetailResponseDto
}
