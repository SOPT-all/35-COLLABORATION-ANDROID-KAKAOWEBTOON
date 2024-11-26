package com.example.kakaowebtoon.presentation.ui.home

import androidx.lifecycle.ViewModel
import com.example.kakaowebtoon.domain.usecase.DummyUseCase
import com.example.kakaowebtoon.presentation.type.HomeDayType
import com.example.kakaowebtoon.presentation.type.HomeGenreType
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Locale
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val dummyUseCase: DummyUseCase
) : ViewModel() {
    private val _webtoonList = MutableStateFlow(emptyList<String>())
    val webtoonList = _webtoonList.asStateFlow()

    private val _selectedDay = MutableStateFlow(0)
    val selectedDay = _selectedDay.asStateFlow()

    private val _selectedGenreType = MutableStateFlow(HomeGenreType.ALL)
    val selectedGenreType = _selectedGenreType.asStateFlow()

    private val dummyWebtoonList = listOf(
        "https://i.ibb.co/ZHdMM0m/img-home-tooncard22.png",
        "https://i.ibb.co/ZHdMM0m/img-home-tooncard22.png"
//        "https://i.ibb.co/ZHdMM0m/img-home-tooncard22.png",
//        "https://i.ibb.co/ZHdMM0m/img-home-tooncard22.png",
//        "https://i.ibb.co/ZHdMM0m/img-home-tooncard22.png",
//        "https://i.ibb.co/ZHdMM0m/img-home-tooncard22.png",
//        "https://i.ibb.co/ZHdMM0m/img-home-tooncard22.png",
//        "https://i.ibb.co/ZHdMM0m/img-home-tooncard22.png",
//        "https://i.ibb.co/ZHdMM0m/img-home-tooncard22.png",
//        "https://i.ibb.co/ZHdMM0m/img-home-tooncard22.png",
//        "https://i.ibb.co/ZHdMM0m/img-home-tooncard22.png",
//        "https://i.ibb.co/ZHdMM0m/img-home-tooncard22.png",
//        "https://i.ibb.co/ZHdMM0m/img-home-tooncard22.png",
//        "https://i.ibb.co/ZHdMM0m/img-home-tooncard22.png",
//        "https://i.ibb.co/ZHdMM0m/img-home-tooncard22.png",
//        "https://i.ibb.co/ZHdMM0m/img-home-tooncard22.png"
    )

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
        _webtoonList.update {
            // useCase
            dummyWebtoonList
        }
    }

    fun onSelectGenreTab(genreType: HomeGenreType) {
        _selectedGenreType.update { genreType }
    }

    fun onSelectDayTab(index: Int) {
        _selectedDay.update { index }
    }
}
