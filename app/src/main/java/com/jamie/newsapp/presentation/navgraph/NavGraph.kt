package com.jamie.newsapp.presentation.navgraph

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.jamie.newsapp.presentation.onboarding.OnboardingScreen
import com.jamie.newsapp.presentation.onboarding.OnboardingViewModel

@Composable
fun NavGraph(startDestination: String) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = startDestination) {
        navigation(route = Route.AppStartNavigation.route, startDestination = Route.OnboardingScreen.route) {
            composable(route = Route.OnboardingScreen.route) {
                val viewModel: OnboardingViewModel = hiltViewModel()
                OnboardingScreen(viewModel::onEvent)
            }
        }
        navigation(route = Route.NewsNavigation.route, startDestination = Route.NewsNavigationScreen.route) {
            composable(route = Route.NewsNavigationScreen.route) {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    Text(text = "News navigation screen text view.")
                }
            }
        }
    }
}