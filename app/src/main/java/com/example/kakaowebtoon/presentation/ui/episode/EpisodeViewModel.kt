package com.example.kakaowebtoon.presentation.ui.episode

import androidx.lifecycle.ViewModel
import com.example.kakaowebtoon.domain.model.EpisodeCard
import com.example.kakaowebtoon.domain.model.WebtoonDetail
import com.example.kakaowebtoon.domain.usecase.DummyUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class EpisodeViewModel @Inject constructor(
    private val dummyUseCase: DummyUseCase
) : ViewModel() {
    private val _webtoonDetail = MutableStateFlow<WebtoonDetail?>(null)
    val webtoonDetail: StateFlow<WebtoonDetail?> = _webtoonDetail.asStateFlow()

    private val _episodeDummyList = MutableStateFlow<List<EpisodeCard>>(emptyList())
    val episodeDummyList: StateFlow<List<EpisodeCard>> = _episodeDummyList.asStateFlow()

    init {
        loadDummyWebtoonDetail()
        loadDummyEpisodeCards()
    }

    private fun loadDummyWebtoonDetail() {
        val dummyDetail = WebtoonDetail(
            imageUrl = "https://i.ibb.co/N7WKG7j/i-OS-png.png",
            title = "어쿠스틱 라이프",
            author = "난다",
            genre = "코믹/일상",
            viewCount = 270000000,
            heartCount = 2007000,
            coupon = 10,
            promotion = "연재무료"
        )
        _webtoonDetail.value = dummyDetail
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
