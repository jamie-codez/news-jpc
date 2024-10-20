package com.jamie.newsapp

import android.os.Bundle
import android.util.Log
import android.view.Window
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.lifecycleScope
import com.jamie.newsapp.domain.usecases.AppEntryUseCases
import com.jamie.newsapp.presentation.onboarding.OnboardingScreen
import com.jamie.newsapp.presentation.onboarding.OnboardingViewModel
import com.jamie.newsapp.ui.theme.NewsAppTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    val viewModel by viewModels<MainViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        actionBar?.hide()
        enableEdgeToEdge()
        installSplashScreen()
        setContent {
            NewsAppTheme {
                Box(modifier = Modifier.background(color = MaterialTheme.colorScheme.background)) {
                    val viewModel: OnboardingViewModel = hiltViewModel()
                    OnboardingScreen(event = viewModel::onEvent)
                }
            }
        }
    }
}


@Preview(showSystemUi = true)
@Composable
fun AppPreview() {
    NewsAppTheme {
        val viewModel: OnboardingViewModel = hiltViewModel()
        OnboardingScreen(event = viewModel::onEvent)
    }
}