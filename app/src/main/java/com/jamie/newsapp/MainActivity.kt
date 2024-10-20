package com.jamie.newsapp

import android.os.Bundle
import android.view.Window
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.jamie.newsapp.presentation.onboarding.OnboardingScreen
import com.jamie.newsapp.ui.theme.NewsAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        actionBar?.hide()
        enableEdgeToEdge()
        installSplashScreen()
        setContent {
            NewsAppTheme {
                Box(modifier= Modifier.background(color = MaterialTheme.colorScheme.background)){
                    OnboardingScreen()
                }
            }
        }
    }
}


@Preview(showSystemUi = true)
@Composable
fun AppPreview(){
    NewsAppTheme {
        OnboardingScreen()
    }
}