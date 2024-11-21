package com.example.kakaowebtoon.presentation.ui.episode

import androidx.lifecycle.ViewModel
import com.example.kakaowebtoon.domain.model.WebtoonDetail
import com.example.kakaowebtoon.domain.usecase.DummyUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class EpisodeViewModel @Inject constructor(
    private val dummyUseCase: DummyUseCase
) : ViewModel(){
    private val _webtoonDetail = MutableStateFlow<WebtoonDetail?>(null)
    val webtoonDetail: StateFlow<WebtoonDetail?> = _webtoonDetail

    init {
        loadDummyWebtoonDetail()
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
            promotion = "연재 무료"
        )
        _webtoonDetail.value = dummyDetail
    }
}
