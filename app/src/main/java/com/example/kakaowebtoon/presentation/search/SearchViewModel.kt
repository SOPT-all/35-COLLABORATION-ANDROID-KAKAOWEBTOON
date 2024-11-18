package com.example.kakaowebtoon.presentation.search

import androidx.lifecycle.ViewModel
import com.example.kakaowebtoon.domain.usecase.DummyUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val dummyUseCase: DummyUseCase
) : ViewModel()