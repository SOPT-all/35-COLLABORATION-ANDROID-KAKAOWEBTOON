package com.example.kakaowebtoon.presentation.ui.home

import androidx.lifecycle.ViewModel
import com.example.kakaowebtoon.domain.usecase.DummyUseCase
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

    // TODO: KakaoWebtoonIndicator 일부 수정 필요하여 논의 후 반영
    private val _selectedDay = MutableStateFlow("")
    val selectedDay = _selectedDay.asStateFlow()

    // TODO: 추후 API에서 장르 값이 함께 넘어올 시 사용될 예정 (for filtering)
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

    // _selectedDay의 초기 값을 그냥 오늘로 박기 vs 함수 호출
    private fun getToday() {
        val formatter = DateTimeFormatter.ofPattern("EEE", Locale.ENGLISH)
        _selectedDay.update {
            LocalDate.now().format(formatter).lowercase(Locale.ENGLISH)
        }
    }

    fun getWebtoonList(day: String) {
        _webtoonList.update {
            // useCase
            dummyWebtoonList
        }
    }
}
