package net.appthos.mvvm.presentation.detail.viewmodel

import androidx.lifecycle.MutableLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import net.appthos.mvvm.core.extensions.addTo
import net.appthos.mvvm.core.presentation.BaseViewModel
import net.appthos.mvvm.domain.interactors.ColorChipInteractor
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val colorChipInteractor: ColorChipInteractor
) : BaseViewModel() {
    internal val viewState = MutableLiveData<DetailViewState>()

    fun fetchColorSet(id: Long) {
        colorChipInteractor.getColorSet(id)
            .toObservable()
            .map<DetailViewState> { DetailViewState.Success(DetailMapper().map(it)) }
            .onErrorReturn { DetailViewState.Error(it.message ?: "Unknown error!!") }
            .startWithItem(DetailViewState.Loading)

            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { viewState.value = it }
            .addTo(disposableBag)
    }
}