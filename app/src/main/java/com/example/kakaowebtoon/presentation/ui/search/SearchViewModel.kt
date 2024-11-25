package com.example.kakaowebtoon.presentation.ui.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kakaowebtoon.domain.model.WebtoonCard
import com.example.kakaowebtoon.domain.usecase.DummyUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.collections.immutable.persistentListOf
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val dummyUseCase: DummyUseCase
) : ViewModel() {
    private val _searchText = MutableStateFlow("")
    val searchText: StateFlow<String> = _searchText.asStateFlow()

    private val _webtoonSearchList = MutableStateFlow<List<WebtoonCard>>(emptyList())
    val webtoonSearchList: StateFlow<List<WebtoonCard>> = _webtoonSearchList.asStateFlow()

    private val _webtoonDummyList = MutableStateFlow<List<WebtoonCard>>(emptyList())
    val webtoonDummyList: StateFlow<List<WebtoonCard>> = _webtoonDummyList.asStateFlow()

    private val dummyList = persistentListOf(
        WebtoonCard(
            imageUrl = "https://i.ibb.co/JrRcFQ9/img-storage-toon01.png",
            title = "어쿠스틱 라이프",
            promotion = "연재 무료",
            author = "난다",
            genre = "#로맨스"
        )
    )

    init {
        loadDummyWebtoonCards()
        observeSearchText()
    }

    fun updateSearchText(newText: String) {
        _searchText.value = newText.replace("\n", "")
    }

    private fun loadDummyWebtoonCards() {
        val dummyWebtoons = listOf(
            WebtoonCard(
                imageUrl = "https://i.ibb.co/sszrRjn/img-storage-toon04.png",
                title = "청춘 로맨스",
                promotion = "시계",
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
                promotion = "시계",
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
                promotion = "시계",
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
                promotion = "시계",
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
                promotion = "시계",
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
        _webtoonDummyList.value = dummyWebtoons
    }

    private fun observeSearchText() {
        viewModelScope.launch {
            _searchText.collectLatest { text ->
                val filteredList = if (text.isNotEmpty()) {
                    dummyList.filter {
                        it.title.contains(text, ignoreCase = true)
                    }
                } else {
                    emptyList()
                }
                _webtoonSearchList.value = filteredList
            }
        }
    }
}
