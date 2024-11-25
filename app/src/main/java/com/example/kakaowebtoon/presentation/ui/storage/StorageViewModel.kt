package com.example.kakaowebtoon.presentation.ui.storage

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kakaowebtoon.domain.model.WebtoonCard
import com.example.kakaowebtoon.domain.usecase.RecentWebtoonsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StorageViewModel @Inject constructor(
    private val recentWebtoonsUseCase: RecentWebtoonsUseCase
) : ViewModel() {
    private val _recentWebtoonList = MutableStateFlow<List<WebtoonCard>>(emptyList())
    val recentWebtoonList: StateFlow<List<WebtoonCard>> = _recentWebtoonList

    init {
        loadRecentWebtoons()
    }

    private fun loadRecentWebtoons() {
        viewModelScope.launch {
            try {
                val response = recentWebtoonsUseCase()
                response.onSuccess { result ->
                    val webtoons = result.data.webtoons
                    _recentWebtoonList.value = webtoons.map { webtoon ->
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
                        "StorageViewModel",
                        "Fail ${throwable.message}",
                        throwable
                    )
                }
            } catch (e: Exception) {
                Log.e("StorageViewModel", "Exception: ${e.message}", e)
            }
        }
    }
}
