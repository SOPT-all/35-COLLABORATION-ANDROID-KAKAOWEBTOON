package com.example.kakaowebtoon.domain.model

enum class MainViewIndicatorContents(val contents: String) {
    NEW("신작"),
    MONDAY("월"),
    TUESDAY("화"),
    WEDNESDAY("수"),
    THURSDAY("목"),
    FRIDAY("금"),
    SATURDAY("토"),
    SUNDAY("일"),
    COMPLETE("완결")
}

enum class EpisodeViewIndicatorContents(val contents: String) {
    EPISODES("회차"),
    DETAILS("정보"),
    TICKETS("이용권"),
    COMMENTS("댓글")
}

enum class StorageViewIndicatorContents(val contents: String) {
    RECENTLY_VIEWED("최근 감상"),
    FAVORITES("찜한 작품"),
    PURCHASED("구매 작품"),
    DOWNLOADED("다운로드"),
    COMMENTS("댓글")
}
