package com.jamie.newsapp.presentation.home

import androidx.lifecycle.ViewModel
import com.jamie.newsapp.domain.usecases.news.NewsUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val newsUseCases: NewsUseCases): ViewModel() {
}