package net.appthos.mvvm.viewmodel

sealed class MainViewState {
    object Loading : MainViewState()
    object  Success : MainViewState()
    data class Error(val msg: String) : MainViewState()
}
