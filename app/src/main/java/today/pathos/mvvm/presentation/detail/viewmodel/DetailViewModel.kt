package today.pathos.mvvm.presentation.detail.viewmodel

import androidx.lifecycle.MutableLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import today.pathos.mvvm.core.extensions.addTo
import today.pathos.mvvm.core.presentation.BaseViewModel
import today.pathos.mvvm.domain.interactors.ColorChipInteractor
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val colorChipInteractor: ColorChipInteractor,
    private val detailMapper: DetailMapper
) : BaseViewModel() {
    internal val viewState = MutableLiveData<DetailViewState>()

    fun fetchColorSet(id: Long) {
        colorChipInteractor.getColorSet(id)
            .toObservable()
            .map<DetailViewState> { DetailViewState.Success(detailMapper.map(it)) }
            .onErrorReturn { DetailViewState.Error(it.message ?: "Unknown error!!") }
            .startWithItem(DetailViewState.Loading)

            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { viewState.value = it }
            .addTo(disposableBag)
    }
}