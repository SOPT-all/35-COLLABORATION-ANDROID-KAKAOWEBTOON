package com.example.kakaowebtoon.presentation.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kakaowebtoon.domain.model.WebtoonCard
import com.example.kakaowebtoon.domain.usecase.GetDailyWebtoonUseCase
import com.example.kakaowebtoon.presentation.type.HomeDayType
import com.example.kakaowebtoon.presentation.type.HomeGenreType
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Locale
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getDailyWebtoonUseCase: GetDailyWebtoonUseCase
) : ViewModel() {
    private val _webtoonList = MutableStateFlow(emptyList<WebtoonCard>())
    val webtoonList = _webtoonList.asStateFlow()

    private val _selectedDay = MutableStateFlow(0)
    val selectedDay = _selectedDay.asStateFlow()

    private val _selectedGenreType = MutableStateFlow(HomeGenreType.ALL)
    val selectedGenreType = _selectedGenreType.asStateFlow()

    init {
        getToday()
    }

    private fun getToday() {
        val formatter = DateTimeFormatter.ofPattern("EEE", Locale.ENGLISH)
        val localDay = LocalDate.now().format(formatter).lowercase(Locale.ENGLISH)
        val today = HomeDayType.entries.indexOfFirst { it.day == localDay } + 1
        _selectedDay.update { today }
    }

    fun getWebtoonList(dayIndex: Int) {
        viewModelScope.launch {
            getDailyWebtoonUseCase(
                when (dayIndex) {
                    1 -> "mon"
                    2 -> "tue"
                    3 -> "wed"
                    4 -> "thu"
                    5 -> "fri"
                    6 -> "sat"
                    7 -> "sun"
                    else -> "mon"
                }
            ).onSuccess { webtoonList ->
                _webtoonList.update { webtoonList }
            }.onFailure {
                it.printStackTrace()
            }
        }
    }

    fun onSelectGenreTab(genreType: HomeGenreType) {
        _selectedGenreType.update { genreType }
    }

    fun onSelectDayTab(index: Int) {
        _selectedDay.update { index }
        getWebtoonList(index)
    }
}
