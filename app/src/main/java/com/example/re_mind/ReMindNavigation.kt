package com.example.re_mind

import androidx.navigation.NavHostController

sealed class ReMindRoutes(val route: String) {
    object Splash : ReMindRoutes("splash")

    object Start : ReMindRoutes("Start")
}

class ReMindNavigationActions(private val navController: NavHostController) {
    fun navigateTo(routes: String) {
        navController.navigate(routes) {
            if (routes == ReMindRoutes.Splash.route) {
                popUpTo(navController.graph.id) { inclusive = true }
                launchSingleTop = true
                restoreState = false
            }
        }
    }
}