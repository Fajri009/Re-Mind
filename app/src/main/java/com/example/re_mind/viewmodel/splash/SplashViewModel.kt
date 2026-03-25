package com.example.re_mind.viewmodel.splash

import androidx.lifecycle.viewModelScope
import com.example.re_mind.ReMindRoutes
import com.example.re_mind.viewmodel.BaseViewModel
import com.example.re_mind.viewmodel.BaseViewModelType
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

interface SplashViewModelType : BaseViewModelType {
    fun checkSession()
}

@HiltViewModel
class SplashViewModel
@Inject
constructor() : BaseViewModel(), SplashViewModelType {
    init {
        viewModelScope.launch {
            delay(2000)
            checkSession()
        }
    }

    override fun checkSession() {
        navigateTo(ReMindRoutes.Start.route)
    }
}

class PreviewSplashViewModel() : BaseViewModel(), BaseViewModelType {

}