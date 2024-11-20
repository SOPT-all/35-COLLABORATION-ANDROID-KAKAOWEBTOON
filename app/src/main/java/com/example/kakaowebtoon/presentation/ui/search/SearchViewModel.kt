package com.example.kakaowebtoon.presentation.ui.search

import androidx.lifecycle.ViewModel
import com.example.kakaowebtoon.domain.model.WebtoonCard
import com.example.kakaowebtoon.domain.usecase.DummyUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val dummyUseCase: DummyUseCase
) : ViewModel() {

    private val _webtoonSearchList = MutableStateFlow<List<WebtoonCard>>(emptyList())
    val webtoonSearchList: StateFlow<List<WebtoonCard>> = _webtoonSearchList

    private val _webtoonDummyList = MutableStateFlow<List<WebtoonCard>>(emptyList())
    val webtoonDummyList: StateFlow<List<WebtoonCard>> = _webtoonDummyList

    init {
        loadSearchWebtoonCards()
        loadDummyWebtoonCards()
    }

    private fun loadSearchWebtoonCards() {
        val dummyData = listOf(
            WebtoonCard(
                imageUrl = "https://i.ibb.co/JrRcFQ9/img-storage-toon01.png",
                title = "어쿠스틱 라이프",
                promotion = "연재 무료",
                author = "난다",
                genre = "#로맨스"
            )
        )
        _webtoonSearchList.value = dummyData
    }

    private fun loadDummyWebtoonCards() {
        val dummyData = listOf(
            WebtoonCard(
                imageUrl = "https://i.ibb.co/sszrRjn/img-storage-toon04.png",
                title = "청춘 로맨스",
                promotion = "3다무",
                author = "미울, BV",
                genre = "#로맨스"
            ),
            WebtoonCard(
                imageUrl = "https://i.ibb.co/sszrRjn/img-storage-toon04.png",
                title = "귀짤 로맨스",
                promotion = "연재 무료",
                author = "이영원",
                genre = "#로맨스"
            ),
            WebtoonCard(
                imageUrl = "https://i.ibb.co/sszrRjn/img-storage-toon04.png",
                title = "청춘 로맨스",
                promotion = "3다무",
                author = "미울, BV",
                genre = "#로맨스"
            ),
            WebtoonCard(
                imageUrl = "https://i.ibb.co/sszrRjn/img-storage-toon04.png",
                title = "귀짤 로맨스",
                promotion = "연재 무료",
                author = "이영원",
                genre = "#로맨스"
            ),
            WebtoonCard(
                imageUrl = "https://i.ibb.co/sszrRjn/img-storage-toon04.png",
                title = "청춘 로맨스",
                promotion = "3다무",
                author = "미울, BV",
                genre = "#로맨스"
            ),
            WebtoonCard(
                imageUrl = "https://i.ibb.co/sszrRjn/img-storage-toon04.png",
                title = "귀짤 로맨스",
                promotion = "연재 무료",
                author = "이영원",
                genre = "#로맨스"
            ),
            WebtoonCard(
                imageUrl = "https://i.ibb.co/sszrRjn/img-storage-toon04.png",
                title = "청춘 로맨스",
                promotion = "3다무",
                author = "미울, BV",
                genre = "#로맨스"
            ),
            WebtoonCard(
                imageUrl = "https://i.ibb.co/sszrRjn/img-storage-toon04.png",
                title = "귀짤 로맨스",
                promotion = "연재 무료",
                author = "이영원",
                genre = "#로맨스"
            ),
            WebtoonCard(
                imageUrl = "https://i.ibb.co/sszrRjn/img-storage-toon04.png",
                title = "청춘 로맨스",
                promotion = "3다무",
                author = "미울, BV",
                genre = "#로맨스"
            ),
            WebtoonCard(
                imageUrl = "https://i.ibb.co/sszrRjn/img-storage-toon04.png",
                title = "귀짤 로맨스",
                promotion = "연재 무료",
                author = "이영원",
                genre = "#로맨스"
            )
        )
        _webtoonDummyList.value = dummyData
    }
}
