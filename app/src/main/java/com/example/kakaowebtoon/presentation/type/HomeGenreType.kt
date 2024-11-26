package com.example.kakaowebtoon.presentation.type

enum class HomeGenreType(
    val genre: String
) {
    ALL(genre = "전체"),
    DAILY_OR_GAG(genre = "일상/개그"),
    ROMANCE(genre = "로맨스"),
    DRAMA(genre = "드라마"),
    ACADEMY_OR_ACTION(genre = "학원/액션"),
    FANTASY_OR_MARTIAL_ARTS(genre = "판타지/무협"),
    THRILLER(genre = "스릴러")
}
