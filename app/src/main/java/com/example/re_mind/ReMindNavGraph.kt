package com.example.re_mind

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.re_mind.ui.module.auth.LoginScreen
import com.example.re_mind.ui.module.auth.RegisterScreen
import com.example.re_mind.ui.module.auth.StartScreen
import com.example.re_mind.ui.module.dashboard.DashboardScreen
import com.example.re_mind.ui.module.notification.NotificationScreen
import com.example.re_mind.ui.module.perform.PerformScreen
import com.example.re_mind.ui.module.splash.SplashScreen
import com.example.re_mind.ui.module.task.TaskScreen
import com.example.re_mind.ui.module.user.UserScreen
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
        val navigateLogin = { navActions.navigateTo(ReMindRoutes.Login.route) }
        val navigateRegister = { navActions.navigateTo(ReMindRoutes.Register.route) }
        val navigateDashboard = { navActions.navigateTo(ReMindRoutes.Dashboard.route) }
        val navigateNotification = { navActions.navigateTo(ReMindRoutes.Notification.route) }
        val navigateTask = { navActions.navigateTo(ReMindRoutes.Task.route) }
        val navigatePerform = { navActions.navigateTo(ReMindRoutes.Perform.route) }
        val navigateUser = { navActions.navigateTo(ReMindRoutes.User.route) }

        val navRoutes = listOf(
            ReMindRoutes.Dashboard.route,
            ReMindRoutes.Task.route,
            ReMindRoutes.Perform.route,
            ReMindRoutes.User.route
        )

        composable(route = ReMindRoutes.Splash.route) {
            val viewModel = hiltViewModel<SplashViewModel>()

            SplashScreen(
                viewModel = viewModel,
                navigateStart = navigateStart,
                navigateHome = {}
            )
        }

        composable(route = ReMindRoutes.Start.route) {
            StartScreen(
                navigateLogin = navigateLogin,
                navigateRegister = navigateRegister
            )
        }

        composable(route = ReMindRoutes.Login.route) {
            LoginScreen(
                navigateStart = navigateStart,
                navigateDashboard = navigateDashboard
            )
        }

        composable(route = ReMindRoutes.Register.route) {
            RegisterScreen(
                navigateBack = { navController.popBackStack() },
                navigateLogin = navigateLogin
            )
        }

        composable(route = ReMindRoutes.Dashboard.route) {
            DashboardScreen(
                navigateNotification = navigateNotification,
                navActions = navActions,
                navRoutes = navRoutes
            )
        }

        composable(route = ReMindRoutes.Notification.route) {
            NotificationScreen(navigateBack = { navController.popBackStack() })
        }

        composable(route = ReMindRoutes.Task.route) {
            TaskScreen(
                navActions = navActions,
                navRoutes = navRoutes
            )
        }

        composable(route = ReMindRoutes.Perform.route) {
            PerformScreen()
        }

        composable(route = ReMindRoutes.User.route) {
            UserScreen()
        }
    }
}