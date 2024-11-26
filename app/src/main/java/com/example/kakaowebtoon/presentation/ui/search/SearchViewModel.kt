package com.example.kakaowebtoon.presentation.ui.search

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kakaowebtoon.domain.model.WebtoonCard
import com.example.kakaowebtoon.domain.usecase.SearchWebtoonsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val searchWebtoonsUseCase: SearchWebtoonsUseCase
) : ViewModel() {
    private val _searchText = MutableStateFlow("")
    val searchText: StateFlow<String> = _searchText.asStateFlow()

    private val _webtoonSearchList = MutableStateFlow<List<WebtoonCard>>(emptyList())
    val webtoonSearchList: StateFlow<List<WebtoonCard>> = _webtoonSearchList.asStateFlow()

    private val _webtoonDummyList = MutableStateFlow<List<WebtoonCard>>(emptyList())
    val webtoonDummyList: StateFlow<List<WebtoonCard>> = _webtoonDummyList.asStateFlow()

    init {
        loadDummyWebtoonCards()
    }

    fun updateSearchText(newText: String) {
        _searchText.value = newText
        if (newText.isNotBlank()) {
            searchWebtoons(newText)
        } else {
            _webtoonSearchList.value = emptyList()
        }
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

    private fun searchWebtoons(title: String) {
        viewModelScope.launch {
            try {
                val response = searchWebtoonsUseCase(title = title)
                response.onSuccess { result ->
                    val webtoons = result.data.webtoons
                    _webtoonSearchList.value = webtoons.map { webtoon ->
                        WebtoonCard(
                            imageUrl = webtoon.image ?: "",
                            title = webtoon.title,
                            promotion = webtoon.promotion,
                            author = webtoon.author,
                            genre = "#${webtoon.genre}"
                        )
                    }
                }
                response.onFailure { throwable ->
                    Log.e(
                        "SearchViewModel",
                        "Fail ${throwable.message}",
                        throwable
                    )
                }
            } catch (e: Exception) {
                Log.e("SearchViewModel", "Exception: ${e.message}", e)
            }
        }
    }
}
