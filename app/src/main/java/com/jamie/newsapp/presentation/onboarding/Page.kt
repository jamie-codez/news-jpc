package com.jamie.newsapp.presentation.onboarding

import androidx.annotation.DrawableRes
import com.jamie.newsapp.R

data class Page(val title: String,val description: String,@DrawableRes val image: Int)

val pages = listOf(
    Page(title = "Lorem Ipsum is dummy text.", description = "Lorem Ipsum is simply dummy test for printing ant typesetting industry.", image = R.drawable.onboarding1),
    Page(title = "Lorem Ipsum is dummy text.", description = "Lorem Ipsum is simply dummy test for printing ant typesetting industry.", image = R.drawable.onboarding2),
    Page(title = "Lorem Ipsum is dummy text.", description = "Lorem Ipsum is simply dummy test for printing ant typesetting industry.", image = R.drawable.onboarding3),
)
