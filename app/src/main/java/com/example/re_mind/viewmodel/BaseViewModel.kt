package com.example.re_mind.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow

interface BaseViewModelType {
    val navigationEvent: SharedFlow<String?>

    fun navigateTo(route: String)

    fun onNavigationComplete()
}

open class BaseViewModel : ViewModel(), BaseViewModelType {
    private val _navigationEvent = MutableSharedFlow<String?>(replay = 1)
    override val navigationEvent: SharedFlow<String?> = _navigationEvent.asSharedFlow()

    override fun navigateTo(route: String) {
        _navigationEvent.tryEmit(route)
    }

    override fun onNavigationComplete() {
        _navigationEvent.tryEmit(null)
    }
}

sealed class FetchDataState<out T> {
    data object Loading : FetchDataState<Nothing>()

    data class Success<out T>(val data: T) : FetchDataState<T>()

    data class Error(val message: String) : FetchDataState<Nothing>()
}