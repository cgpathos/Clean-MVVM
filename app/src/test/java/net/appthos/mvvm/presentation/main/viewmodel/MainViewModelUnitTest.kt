package net.appthos.mvvm.presentation.main.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry
import androidx.lifecycle.Observer
import io.reactivex.rxjava3.core.Single
import net.appthos.mvvm.core.rx.RxSchedulerRule
import net.appthos.mvvm.model.interactors.ColorChipInteractor
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnit

class MainViewModelUnitTest {
    @Rule @JvmField val mockitoRule = MockitoJUnit.rule()!!
    @Rule @JvmField val instantExecutorRule = InstantTaskExecutorRule()
    @Rule @JvmField val rxSchedulerRule = RxSchedulerRule()

    @Mock lateinit var interactor: ColorChipInteractor
    @Mock lateinit var observer: Observer<MainViewState>
    @Mock lateinit var lifecycleOwner: LifecycleOwner

    private lateinit var lifecycle: Lifecycle
    private lateinit var viewModel: MainViewModel

    @Before
    fun setUp() {
        lifecycle = LifecycleRegistry(lifecycleOwner)
        viewModel = MainViewModel(interactor)
        viewModel.viewState.observeForever(observer)
    }

    @Test
    fun testFetchDataSuccess() {
        Mockito
            .`when`(interactor.getColorSetList())
            .thenReturn(Single.just(ArrayList()))
        viewModel.fetchColorSetList()
        Mockito.verify(observer).onChanged(MainViewState.Loading)
        Mockito.verify(observer).onChanged(MainViewState.Success(ArrayList()))
    }

    @Test
    fun testFetchDataError() {
        Mockito
            .`when`(interactor.getColorSetList())
            .thenReturn(Single.error(Throwable("Something wrong...")))
        viewModel.fetchColorSetList()
        Mockito.verify(observer).onChanged(MainViewState.Loading)
        Mockito.verify(observer).onChanged(MainViewState.Error("Something wrong..."))
    }
}