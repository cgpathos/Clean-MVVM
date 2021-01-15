package net.appthos.mvvm.presentation.main.viewmodel

import androidx.test.platform.app.InstrumentationRegistry
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import io.reactivex.rxjava3.internal.util.NotificationLite.getValue
import net.appthos.mvvm.model.interactors.ColorChipInteractor
import org.junit.*
import org.junit.rules.RuleChain
import javax.inject.Inject
import kotlin.jvm.Throws

@HiltAndroidTest
class MainViewModelTest {
    private lateinit var viewModel: MainViewModel
    private val hiltRule = HiltAndroidRule(this)

    @get:Rule
    val rule = RuleChain
        .outerRule(hiltRule)

    @Inject lateinit var colorChipInteractor: ColorChipInteractor

    @Before
    fun setUp() {
        hiltRule.inject()

        viewModel = MainViewModel(colorChipInteractor)
    }

    @Test
    fun testFetchColorSetList() {
        Assert.assertFalse(getValue(viewModel.fetchColorSetList()))
    }
}