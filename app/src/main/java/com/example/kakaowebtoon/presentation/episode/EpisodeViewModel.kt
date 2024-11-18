package com.example.kakaowebtoon.presentation.episode

import androidx.lifecycle.ViewModel
import com.example.kakaowebtoon.domain.usecase.DummyUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class EpisodeViewModel @Inject constructor(
    private val dummyUseCase: DummyUseCase
) : ViewModel()