package net.appthos.mvvm.presentation.detail.viewmodel

sealed class DetailViewState {
    object Loading : DetailViewState()
    data class  Success(val colorSet: DetailData) : DetailViewState()
    data class Error(val msg: String) : DetailViewState()
}
