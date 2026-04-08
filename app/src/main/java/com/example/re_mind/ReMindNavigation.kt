package com.example.re_mind

import androidx.navigation.NavHostController

sealed class ReMindRoutes(val route: String) {
    object Splash : ReMindRoutes("splash")

    object Start : ReMindRoutes("Start")

    object Login : ReMindRoutes("Login")

    object Register : ReMindRoutes("Register")

    object Dashboard : ReMindRoutes("Dashboard")

    object Notification : ReMindRoutes("Navigation")
}

class ReMindNavigationActions(private val navController: NavHostController) {
    fun navigateTo(routes: String) {
        navController.navigate(routes) {
            if (routes == ReMindRoutes.Start.route) {
                popUpTo(navController.graph.id) { inclusive = true }
                launchSingleTop = true
                restoreState = false
            }
        }
    }
}