package net.appthos.mvvm.presentation.main.viewmodel

sealed class MainViewState {
    object Loading : MainViewState()
    data class Success(val colorSetList: List<MainData>) : MainViewState()
    data class Error(val msg: String) : MainViewState()
}
