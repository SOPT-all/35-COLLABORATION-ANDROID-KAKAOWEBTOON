package com.example.kakaowebtoon.presentation.ui.episode

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kakaowebtoon.domain.model.EpisodeCard
import com.example.kakaowebtoon.domain.model.WebtoonDetail
import com.example.kakaowebtoon.domain.usecase.EpisodeDetailUseCase
import com.example.kakaowebtoon.domain.usecase.EpisodesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import javax.inject.Inject

@HiltViewModel
class EpisodeViewModel @Inject constructor(
    private val episodeDetailUseCase: EpisodeDetailUseCase,
    private val episodesUseCase: EpisodesUseCase
) : ViewModel() {
    private val _webtoonDetail = MutableStateFlow<WebtoonDetail?>(null)
    val webtoonDetail: StateFlow<WebtoonDetail?> = _webtoonDetail.asStateFlow()

    private val _webtoonEpisodes = MutableStateFlow<List<EpisodeCard>>(emptyList())
    val webtoonEpisodes: StateFlow<List<EpisodeCard>> = _webtoonEpisodes.asStateFlow()

    val largestIndexEpisode = _webtoonEpisodes.map { episodes ->
        episodes.filter { it.status != 0 }
            .maxByOrNull { it.index }
    }.stateIn(
        viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = null
    )

    init {
        loadEpisodeDetail(27)
        loadEpisodes(27)
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

    private fun loadEpisodes(webtoonId: Int) {
        viewModelScope.launch {
            val result = episodesUseCase(webtoonId)
            result.onSuccess { response ->
                val inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
                val outputFormatter = DateTimeFormatter.ofPattern("yy.MM.dd")
                val episodes = response.data.episodes.map {
                    EpisodeCard(
                        imageUrl = it.image,
                        index = it.turn,
                        title = it.title,
                        status = it.status,
                        date = try {
                            LocalDate.parse(it.date, inputFormatter).format(outputFormatter)
                        } catch (e: Exception) {
                            "Invalid Date"
                        },
                        dayUntilFree = it.dayUntilFree
                    )
                }
                _webtoonEpisodes.value = episodes
            }.onFailure {

            }
        }
    }
}
