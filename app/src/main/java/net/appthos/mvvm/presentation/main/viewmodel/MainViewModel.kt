package net.appthos.mvvm.presentation.main.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import net.appthos.mvvm.core.extensions.addTo
import net.appthos.mvvm.core.presentation.BaseViewModel
import net.appthos.mvvm.model.interactors.ColorChipInteractor

class MainViewModel @ViewModelInject constructor(
    private val colorChipInteractor: ColorChipInteractor
) : BaseViewModel() {
    internal val viewState = MutableLiveData<MainViewState>()

    fun fetchColorSetList() {
        colorChipInteractor.getColorSetList()
            .toObservable()
            .map<MainViewState> { MainViewState.Success(MainMapper().map(it)) }
            .onErrorReturn { MainViewState.Error(it.message ?: "Unknown error!!") }
            .startWithItem(MainViewState.Loading)

            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { viewState.value = it }
            .addTo(disposableBag)
    }
}