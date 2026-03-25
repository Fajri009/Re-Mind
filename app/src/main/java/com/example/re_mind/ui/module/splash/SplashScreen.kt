package com.example.re_mind.ui.module.splash

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.re_mind.R
import com.example.re_mind.ReMindRoutes
import com.example.re_mind.ui.theme.MtcAppTheme.Color.Companion.Primary500
import com.example.re_mind.ui.theme.MtcAppTheme.Color.Companion.Shades50
import com.example.re_mind.ui.theme.MtcAppTheme.Text.Companion.heading2SemiBold
import com.example.re_mind.viewmodel.BaseViewModelType
import com.example.re_mind.viewmodel.splash.PreviewSplashViewModel

@Composable
fun SplashScreen(
    viewModel: BaseViewModelType,
    navigateStart: () -> Unit,
    navigateHome: () -> Unit
) {
    val navigationEvent by viewModel.navigationEvent.collectAsStateWithLifecycle(null)

    LaunchedEffect(navigationEvent) {
        navigationEvent?.let { route ->
            when (route) {
                ReMindRoutes.Start.route -> navigateStart()
            }
            viewModel.onNavigationComplete()
        }
    }
    
    Scaffold(
        containerColor = Primary500
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
                .background(Primary500),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                modifier = Modifier.size(250.dp),
                painter = painterResource(R.drawable.ic_app),
                contentDescription = "Icon App"
            )
            Spacer(modifier = Modifier.height(30.dp))
            Text(
                text = "Re-Mind",
                color = Shades50,
                style = heading2SemiBold
            )
        }
    }
}

@SuppressLint("ViewModelConstructorInComposable")
@Preview
@Composable
fun SplashScreenPreview() {
    val viewModel = PreviewSplashViewModel()

    SplashScreen(
        viewModel = viewModel,
        navigateStart = {},
        navigateHome = {}
    )
}