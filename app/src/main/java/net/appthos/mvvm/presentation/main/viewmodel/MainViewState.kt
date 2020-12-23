package net.appthos.mvvm.presentation.main.viewmodel

sealed class MainViewState {
    object Loading : MainViewState()
    data class  Success(val colorSetList: List<ColorSetData>) : MainViewState()
    data class Error(val msg: String) : MainViewState()
}
