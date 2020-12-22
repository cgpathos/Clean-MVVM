package net.appthos.mvvm.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import net.appthos.mvvm.core.extensions.addTo
import net.appthos.mvvm.model.entiities.ColorSet
import net.appthos.mvvm.model.interactors.ColorChipInteractor
import net.appthos.mvvm.model.repositories.ApiColorChipRepository

class MainViewModel : ViewModel() {
    companion object {
        const val TAG = "Main1ViewModel"
    }

    private val disposableBag = CompositeDisposable()
    private val colorChipInteractor: ColorChipInteractor by lazy { ColorChipInteractor(ApiColorChipRepository()) }
    val viewState = MutableLiveData<MainViewState>()


    fun fetchColorSetList() {
        colorChipInteractor.getColorSetList()
            .toObservable()
            .map { testMapper(it) }
            .onErrorReturn { MainViewState.Error(it.message ?: "Empty Error!!") }
            .startWithItem(MainViewState.Loading)


            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { viewState.value = it }
            .addTo(disposableBag)
    }

    private fun testMapper(list: List<ColorSet>): MainViewState {
        throw RuntimeException("500 error!!!!")
    }

    override fun onCleared() {
        Log.i(TAG, "onCleared: ")
        if (!disposableBag.isDisposed) {
            disposableBag.dispose()
        }
    }
}