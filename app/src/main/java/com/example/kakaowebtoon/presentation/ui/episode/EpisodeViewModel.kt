package com.example.kakaowebtoon.presentation.ui.episode

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kakaowebtoon.domain.model.EpisodeCard
import com.example.kakaowebtoon.domain.model.WebtoonDetail
import com.example.kakaowebtoon.domain.usecase.EpisodeDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EpisodeViewModel @Inject constructor(
    private val episodeDetailUseCase: EpisodeDetailUseCase
) : ViewModel() {
    private val _webtoonDetail = MutableStateFlow<WebtoonDetail?>(null)
    val webtoonDetail: StateFlow<WebtoonDetail?> = _webtoonDetail.asStateFlow()

    private val _episodeDummyList = MutableStateFlow<List<EpisodeCard>>(emptyList())
    val episodeDummyList: StateFlow<List<EpisodeCard>> = _episodeDummyList.asStateFlow()

    val largestIndexEpisode = _episodeDummyList.map { episodes ->
        episodes.filter { it.status != 0 }
            .maxByOrNull { it.index }
    }.stateIn(
        viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = null
    )

    init {
        loadEpisodeDetail(27)
        loadDummyEpisodeCards()
    }

    private fun loadEpisodeDetail(webtoonId: Int) {
        viewModelScope.launch {
            val result = episodeDetailUseCase(webtoonId)
            result.onSuccess { response ->
                val data = response.data
                _webtoonDetail.value = WebtoonDetail(
                    title = data.title,
                    author = data.author,
                    genre = data.genre,
                    viewCount = data.viewCount,
                    heartCount = data.heartCount,
                    imageUrl = data.image,
                    coupon = data.coupon,
                    promotion = data.promotion
                )
            }.onFailure {
            }
        }
    }

    private fun loadDummyEpisodeCards() {
        val dummyEpisodes = listOf(
            EpisodeCard(
                imageUrl = "https://i.ibb.co/sszrRjn/img-storage-toon04.png",
                index = 0,
                title = "예고",
                status = 10,
                date = "24.10.03",
                dayUntilFree = 0
            ),
            EpisodeCard(
                imageUrl = "https://i.ibb.co/qNmzh5V/img-storage-toon05.png",
                index = 1,
                title = "선언금지",
                status = 7,
                date = "24.10.10",
                dayUntilFree = 0
            ),
            EpisodeCard(
                imageUrl = "https://i.ibb.co/WH4pbTV/img-storage-toon06.png",
                index = 2,
                title = "신문물",
                status = 3,
                date = "24.10.17",
                dayUntilFree = 0
            ),
            EpisodeCard(
                imageUrl = "https://i.ibb.co/xCF0VNF/img-storage-toon07.png",
                index = 3,
                title = "선언금지",
                status = 0,
                date = "24.11.25",
                dayUntilFree = 3
            ),
            EpisodeCard(
                imageUrl = "https://i.ibb.co/sszrRjn/img-storage-toon04.png",
                index = 0,
                title = "예고",
                status = 10,
                date = "24.10.03",
                dayUntilFree = 0
            ),
            EpisodeCard(
                imageUrl = "https://i.ibb.co/qNmzh5V/img-storage-toon05.png",
                index = 1,
                title = "선언금지",
                status = 7,
                date = "24.10.10",
                dayUntilFree = 0
            ),
            EpisodeCard(
                imageUrl = "https://i.ibb.co/WH4pbTV/img-storage-toon06.png",
                index = 2,
                title = "소원",
                status = 3,
                date = "24.10.17",
                dayUntilFree = 0
            ),
            EpisodeCard(
                imageUrl = "https://i.ibb.co/xCF0VNF/img-storage-toon07.png",
                index = 3,
                title = "왕vs왕",
                status = 0,
                date = "24.11.29",
                dayUntilFree = 7
            ),
            EpisodeCard(
                imageUrl = "https://i.ibb.co/xCF0VNF/img-storage-toon07.png",
                index = 3,
                title = "왕vs왕",
                status = 0,
                date = "24.11.29",
                dayUntilFree = 7
            ),
            EpisodeCard(
                imageUrl = "https://i.ibb.co/sszrRjn/img-storage-toon04.png",
                index = 0,
                title = "예고",
                status = 10,
                date = "24.10.03",
                dayUntilFree = 0
            ),
            EpisodeCard(
                imageUrl = "https://i.ibb.co/qNmzh5V/img-storage-toon05.png",
                index = 1,
                title = "선언금지",
                status = 7,
                date = "24.10.10",
                dayUntilFree = 0
            ),
            EpisodeCard(
                imageUrl = "https://i.ibb.co/WH4pbTV/img-storage-toon06.png",
                index = 2,
                title = "내 동생",
                status = 3,
                date = "24.10.17",
                dayUntilFree = 0
            ),
            EpisodeCard(
                imageUrl = "https://i.ibb.co/xCF0VNF/img-storage-toon07.png",
                index = 3,
                title = "될 것 같은데?",
                status = 0,
                date = "24.11.29",
                dayUntilFree = 7
            ),
            EpisodeCard(
                imageUrl = "https://i.ibb.co/xCF0VNF/img-storage-toon07.png",
                index = 280,
                title = "기능이 많아 도전해보자구요",
                status = 0,
                date = "24.11.29",
                dayUntilFree = 7
            ),
            EpisodeCard(
                imageUrl = "https://i.ibb.co/sszrRjn/img-storage-toon04.png",
                index = 0,
                title = "예고",
                status = 10,
                date = "24.10.03",
                dayUntilFree = 0
            ),
            EpisodeCard(
                imageUrl = "https://i.ibb.co/qNmzh5V/img-storage-toon05.png",
                index = 1,
                title = "선언금지",
                status = 7,
                date = "24.10.10",
                dayUntilFree = 0
            ),
            EpisodeCard(
                imageUrl = "https://i.ibb.co/WH4pbTV/img-storage-toon06.png",
                index = 2,
                title = "소원",
                status = 3,
                date = "24.10.17",
                dayUntilFree = 0
            ),
            EpisodeCard(
                imageUrl = "https://i.ibb.co/xCF0VNF/img-storage-toon07.png",
                index = 3,
                title = "왕 vs 왕",
                status = 0,
                date = "24.11.29",
                dayUntilFree = 7
            ),
            EpisodeCard(
                imageUrl = "https://i.ibb.co/xCF0VNF/img-storage-toon07.png",
                index = 3,
                title = "위로부적격자",
                status = 0,
                date = "24.11.29",
                dayUntilFree = 7
            ),
            EpisodeCard(
                imageUrl = "https://i.ibb.co/sszrRjn/img-storage-toon04.png",
                index = 0,
                title = "예고",
                status = 10,
                date = "24.10.03",
                dayUntilFree = 0
            ),
            EpisodeCard(
                imageUrl = "https://i.ibb.co/qNmzh5V/img-storage-toon05.png",
                index = 1,
                title = "선언금지",
                status = 7,
                date = "24.10.10",
                dayUntilFree = 0
            ),
            EpisodeCard(
                imageUrl = "https://i.ibb.co/WH4pbTV/img-storage-toon06.png",
                index = 2,
                title = "예고",
                status = 3,
                date = "24.10.17",
                dayUntilFree = 0
            ),
            EpisodeCard(
                imageUrl = "https://i.ibb.co/xCF0VNF/img-storage-toon07.png",
                index = 3,
                title = "예고",
                status = 0,
                date = "24.11.29",
                dayUntilFree = 7
            )
        )
        _episodeDummyList.value = dummyEpisodes
    }
}
