package com.jamie.newsapp.data.remote.dto

import com.jamie.newsapp.domain.model.Article

data class NewsResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)