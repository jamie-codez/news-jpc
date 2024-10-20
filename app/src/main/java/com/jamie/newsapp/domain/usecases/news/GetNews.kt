package com.jamie.newsapp.domain.usecases.news

import androidx.paging.PagingData
import com.jamie.newsapp.domain.model.Article
import com.jamie.newsapp.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class GetNews(private val newsRepository: NewsRepository) {
    operator fun invoke(sources: List<String>): Flow<PagingData<Article>> = newsRepository.getNews(sources = sources)
}