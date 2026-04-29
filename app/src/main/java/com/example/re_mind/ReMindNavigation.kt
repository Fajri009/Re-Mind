package com.example.re_mind

import androidx.navigation.NavHostController

sealed class ReMindRoutes(val route: String) {
    object Splash : ReMindRoutes("splash")

    object Start : ReMindRoutes("start")

    object Login : ReMindRoutes("login")

    object Register : ReMindRoutes("register")

    object Dashboard : ReMindRoutes("dashboard")

    object Notification : ReMindRoutes("notification")

    object Task : ReMindRoutes("task")

    object Perform : ReMindRoutes("perform")

    object User : ReMindRoutes("user")
}

class ReMindNavigationActions(private val navController: NavHostController) {
    fun navigateTo(routes: String) {
        navController.navigate(routes) {
            if (routes == ReMindRoutes.Start.route || routes == ReMindRoutes.Dashboard.route) {
                popUpTo(navController.graph.id) { inclusive = true }
                launchSingleTop = true
                restoreState = false
            }
        }
    }
}