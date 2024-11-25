package com.example.kakaowebtoon.presentation.ui.storage

import androidx.lifecycle.ViewModel
import com.example.kakaowebtoon.domain.model.WebtoonCard
import com.example.kakaowebtoon.domain.usecase.DummyUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class StorageViewModel @Inject constructor(
    private val dummyUseCase: DummyUseCase
) : ViewModel() {
    private val _webtoonDummyList = MutableStateFlow<List<WebtoonCard>>(emptyList())
    val webtoonDummyList: StateFlow<List<WebtoonCard>> = _webtoonDummyList

    init {
        loadDummyWebtoonCards()
    }

    private fun loadDummyWebtoonCards() {
        val dummyWebtoons = listOf(
            WebtoonCard(
                imageUrl = "https://i.ibb.co/JrRcFQ9/img-storage-toon01.png",
                title = "어쿠스틱 라이프",
                promotion = "3다무",
                author = "난다",
                genre = "#코믹/일상"
            ),
            WebtoonCard(
                imageUrl = "https://i.ibb.co/sszrRjn/img-storage-toon04.png",
                title = "웽툰",
                promotion = "연재 무료",
                author = "춘심이",
                genre = "#코믹/일상"
            ),
            WebtoonCard(
                imageUrl = "https://i.ibb.co/qNmzh5V/img-storage-toon05.png",
                title = "ONE",
                promotion = "연재 무료",
                author = "이은재",
                genre = "#학원/판타지"
            ),
            WebtoonCard(
                imageUrl = "https://i.ibb.co/WH4pbTV/img-storage-toon06.png",
                title = "TEN",
                promotion = "3다무",
                author = "이은재",
                genre = "#학원/판타지"
            ),
            WebtoonCard(
                imageUrl = "https://i.ibb.co/xCF0VNF/img-storage-toon07.png",
                title = "청춘극장",
                promotion = "up",
                author = "이은재",
                genre = "#드라마"
            ),
            WebtoonCard(
                imageUrl = "https://i.ibb.co/JrRcFQ9/img-storage-toon01.png",
                title = "어쿠스틱 라이프",
                promotion = "3다무",
                author = "난다",
                genre = "#코믹/일상"
            ),
            WebtoonCard(
                imageUrl = "https://i.ibb.co/sszrRjn/img-storage-toon04.png",
                title = "웽툰",
                promotion = "연재 무료",
                author = "춘심이",
                genre = "#코믹/일상"
            ),
            WebtoonCard(
                imageUrl = "https://i.ibb.co/qNmzh5V/img-storage-toon05.png",
                title = "ONE",
                promotion = "연재 무료",
                author = "이은재",
                genre = "#학원/판타지"
            ),
            WebtoonCard(
                imageUrl = "https://i.ibb.co/WH4pbTV/img-storage-toon06.png",
                title = "TEN",
                promotion = "3다무",
                author = "이은재",
                genre = "#학원/판타지"
            ),
            WebtoonCard(
                imageUrl = "https://i.ibb.co/xCF0VNF/img-storage-toon07.png",
                title = "청춘극장",
                promotion = "up",
                author = "이은재",
                genre = "#드라마"
            ),
            WebtoonCard(
                imageUrl = "https://i.ibb.co/JrRcFQ9/img-storage-toon01.png",
                title = "어쿠스틱 라이프",
                promotion = "3다무",
                author = "난다",
                genre = "#코믹/일상"
            ),
            WebtoonCard(
                imageUrl = "https://i.ibb.co/sszrRjn/img-storage-toon04.png",
                title = "웽툰",
                promotion = "연재 무료",
                author = "춘심이",
                genre = "#코믹/일상"
            ),
            WebtoonCard(
                imageUrl = "https://i.ibb.co/qNmzh5V/img-storage-toon05.png",
                title = "ONE",
                promotion = "연재 무료",
                author = "이은재",
                genre = "#학원/판타지"
            ),
            WebtoonCard(
                imageUrl = "https://i.ibb.co/WH4pbTV/img-storage-toon06.png",
                title = "TEN",
                promotion = "3다무",
                author = "이은재",
                genre = "#학원/판타지"
            ),
            WebtoonCard(
                imageUrl = "https://i.ibb.co/xCF0VNF/img-storage-toon07.png",
                title = "청춘극장",
                promotion = "up",
                author = "이은재",
                genre = "#드라마"
            ),
            WebtoonCard(
                imageUrl = "https://i.ibb.co/JrRcFQ9/img-storage-toon01.png",
                title = "어쿠스틱 라이프",
                promotion = "3다무",
                author = "난다",
                genre = "#코믹/일상"
            ),
            WebtoonCard(
                imageUrl = "https://i.ibb.co/sszrRjn/img-storage-toon04.png",
                title = "웽툰",
                promotion = "연재 무료",
                author = "춘심이",
                genre = "#코믹/일상"
            ),
            WebtoonCard(
                imageUrl = "https://i.ibb.co/qNmzh5V/img-storage-toon05.png",
                title = "ONE",
                promotion = "연재 무료",
                author = "이은재",
                genre = "#학원/판타지"
            ),
            WebtoonCard(
                imageUrl = "https://i.ibb.co/WH4pbTV/img-storage-toon06.png",
                title = "TEN",
                promotion = "3다무",
                author = "이은재",
                genre = "#학원/판타지"
            ),
            WebtoonCard(
                imageUrl = "https://i.ibb.co/xCF0VNF/img-storage-toon07.png",
                title = "청춘극장",
                promotion = "up",
                author = "이은재",
                genre = "#드라마"
            )
        )
        _webtoonDummyList.value = dummyWebtoons
    }
}
