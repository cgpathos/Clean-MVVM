package net.appthos.mvvm.presentation.main.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import net.appthos.mvvm.model.interactors.ColorChipInteractor
import net.appthos.mvvm.presentation.main.core.getValue
import org.junit.*
import org.junit.rules.RuleChain
import javax.inject.Inject
import kotlin.jvm.Throws

@HiltAndroidTest
class MainViewModelTest {
    private lateinit var viewModel: MainViewModel
    private val hiltRule = HiltAndroidRule(this)
    private val instantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    val rule = RuleChain
        .outerRule(hiltRule)
        .around(instantTaskExecutorRule)

    @Inject lateinit var colorChipInteractor: ColorChipInteractor

    @Before
    fun setUp() {
        hiltRule.inject()

        viewModel = MainViewModel(colorChipInteractor)
    }

    @Test
    fun testFetchColorSetList() {
        viewModel.fetchColorSetList()
        Assert.assertNotNull(getValue(viewModel.viewState))
    }
}