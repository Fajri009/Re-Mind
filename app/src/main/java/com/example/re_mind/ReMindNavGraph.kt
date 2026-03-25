package com.example.re_mind

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.re_mind.ui.module.auth.StartScreen
import com.example.re_mind.ui.module.splash.SplashScreen
import com.example.re_mind.viewmodel.splash.SplashViewModel

@Composable
fun ReMindNavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = ReMindRoutes.Splash.route,
    navActions: ReMindNavigationActions =
        remember(navController) { ReMindNavigationActions(navController) }
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        val navigateStart = { navActions.navigateTo(ReMindRoutes.Start.route) }

        composable(route = ReMindRoutes.Splash.route) {
            val viewModel = hiltViewModel<SplashViewModel>()

            SplashScreen(
                viewModel = viewModel,
                navigateStart = navigateStart,
                navigateHome = {}
            )
        }

        composable(route = ReMindRoutes.Start.route) {
            StartScreen()
        }
    }
}