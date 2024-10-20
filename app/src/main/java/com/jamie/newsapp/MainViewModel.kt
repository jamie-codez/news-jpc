package com.jamie.newsapp

import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AndroidViewModel
import com.jamie.newsapp.domain.usecases.AppEntryUseCases
import com.jamie.newsapp.presentation.navgraph.Route
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val appEntryUseCases: AppEntryUseCases,
    private val application: NewsApplication
) : AndroidViewModel(application = application) {
    var splashCondition by mutableStateOf(true)
        private set
    var startDestination by mutableStateOf(Route.AppStartNavigation.route)
        private set

    init {
        appEntryUseCases.readAppEntry().onEach { startFromHomeScreen ->
            startDestination = if (startFromHomeScreen) Route.NewsNavigation.route else Route.AppStartNavigation.route
            delay(3000)
            splashCondition = false
        }
    }
}