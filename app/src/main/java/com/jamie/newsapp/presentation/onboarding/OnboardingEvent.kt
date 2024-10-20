package com.jamie.newsapp.presentation.onboarding

sealed class OnboardingEvent {
    object SaveAppEntry: OnboardingEvent()
}