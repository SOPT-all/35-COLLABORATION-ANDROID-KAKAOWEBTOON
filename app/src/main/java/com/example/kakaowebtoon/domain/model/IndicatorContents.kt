package com.example.kakaowebtoon.domain.model

enum class MainViewIndicatorContents(val contents: String) {
    NEW(contents = "신작"),
    MONDAY(contents = "월"),
    TUESDAY(contents = "화"),
    WEDNESDAY(contents = "수"),
    THURSDAY(contents = "목"),
    FRIDAY(contents = "금"),
    SATURDAY(contents = "토"),
    SUNDAY(contents = "일"),
    COMPLETE(contents = "완결")
}

enum class EpisodeViewIndicatorContents(val contents: String) {
    EPISODES(contents = "회차"),
    DETAILS(contents = "정보"),
    TICKETS(contents = "이용권"),
    COMMENTS(contents = "댓글")
}

enum class StorageViewIndicatorContents(val contents: String) {
    RECENTLY_VIEWED(contents = "최근 감상"),
    FAVORITES(contents = "찜한 작품"),
    PURCHASED(contents = "구매 작품"),
    DOWNLOADED(contents = "다운로드"),
    COMMENTS(contents = "댓글")
}
