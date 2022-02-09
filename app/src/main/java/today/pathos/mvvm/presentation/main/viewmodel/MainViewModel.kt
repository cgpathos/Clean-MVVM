package today.pathos.mvvm.presentation.main.viewmodel

import android.util.Log
import androidx.activity.result.ActivityResultRegistry
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import today.pathos.mvvm.core.extensions.addTo
import today.pathos.mvvm.core.presentation.BaseViewModel
import today.pathos.mvvm.core.presentation.ability.ActivityNavigator
import today.pathos.mvvm.domain.interactors.ColorChipInteractor
import today.pathos.mvvm.presentation.main.viewmodel.ability.ActivityNavigatorDelegator
import javax.inject.Inject

class MainViewModel @AssistedInject constructor(
    @Assisted
    activityResultRegistry: ActivityResultRegistry,
    private val colorChipInteractor: ColorChipInteractor,
    private val mainMapper: MainMapper,
) : BaseViewModel(),
    ActivityNavigator by ActivityNavigatorDelegator(activityResultRegistry) {
    internal val viewState = MutableLiveData<MainViewState>()

    fun fetchColorSetList() {

//        (activity as AppCompatActivity).registerForActivityResult(ActivityResultContracts.StartActivityForResult(), {})
//            .launch(createIntent(activity, target, args))


//        activityResultRegistry.register("Main",ActivityResultContracts.StartActivityForResult()) {
//
//        }
//            .launch(Intent())

        Log.i(TAG, "fetchColorSetList: ${activityResultRegistry == null}")


        launch()


        colorChipInteractor.getColorSetList()
            .toObservable()
            .map<MainViewState> { MainViewState.Success(mainMapper.map(it)) }
            .onErrorReturn { MainViewState.Error(it.message ?: "Unknown error!!") }
            .startWithItem(MainViewState.Loading)

            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { viewState.value = it }
            .addTo(disposableBag)
    }

    @AssistedFactory
    interface Factory {
        fun create(activityResultRegistry: ActivityResultRegistry): MainViewModel
    }

    companion object {
        const val TAG = "MainViewModel"

        fun provideFactory(
            assistedFactory: Factory,
            activityResultRegistry: ActivityResultRegistry,
        ): ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return assistedFactory.create(activityResultRegistry) as T
            }
        }
    }


}
